package com.agrisustain.smartcorn.utils

import android.app.Application
import android.content.Context
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.agrisustain.smartcorn.data.api.ApiResponse
import com.agrisustain.smartcorn.data.api.LoginRequest
import com.agrisustain.smartcorn.data.api.LoginResponse
import com.agrisustain.smartcorn.data.api.RegisterRequest
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AuthViewModel(application: Application) : AndroidViewModel(application){

    private val _loginState = MutableStateFlow<ApiResponse<Any>?>(null)
    val loginState: StateFlow<ApiResponse<Any>?> get() = _loginState

    private val _registerState = MutableStateFlow<ApiResponse<Any>?>(null)
    val registerState: StateFlow<ApiResponse<Any>?> get() = _registerState

    private val _authState = MutableStateFlow(false) // Menyimpan status login
    val authState: StateFlow<Boolean> get() = _authState

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                // Kirim login request dan terima response
                val response = RetrofitClient.instance.login(LoginRequest(email, password))

                if (response.success) {
                    // Ambil token langsung dari ApiResponse
                    val token = response.token

                    // Simpan token di SharedPreferences
                    val sharedPreferences = getApplication<Application>().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
                    sharedPreferences.edit().putString("auth_token", token).apply()

                    _loginState.value = ApiResponse(true, "Login successful", null)
                    _authState.value = true // Set user as logged in
                } else {
                    _loginState.value = ApiResponse(false, "Login failed", null)
                    _authState.value = false
                }
            } catch (e: Exception) {
                _loginState.value = ApiResponse(false, e.message ?: "An error occurred", null)
                _authState.value = false
            }
        }
    }



    fun register(registerRequest: RegisterRequest) {
        viewModelScope.launch {
            try {
                val response = RetrofitClient.instance.register(registerRequest)
                _registerState.value = response
            } catch (e: Exception) {
                _registerState.value = ApiResponse(false, e.message ?: "Error occurred", null)
            }
        }
    }

    // Fungsi signOut
    fun signOut() {
        // Menghapus token dari SharedPreferences
        val sharedPreferences = getApplication<Application>().getSharedPreferences("user_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().remove("auth_token").apply()

        _authState.value = false

        // Menampilkan Toast hanya sekali, setelah signOut selesai
        Toast.makeText(getApplication<Application>(), "Successfully signed out", Toast.LENGTH_SHORT).show()
    }
}


sealed class AuthState {
    object Loading : AuthState()
    object Authenticated : AuthState()
    object Unauthenticated : AuthState()
    data class Error(val message: String) : AuthState()
}


