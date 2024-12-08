package com.agrisustain.smartcorn.utils

import retrofit2.Call
import com.agrisustain.smartcorn.model.LoginRequest
import com.agrisustain.smartcorn.model.LoginResponse
import com.agrisustain.smartcorn.model.RegisterRequest
import com.agrisustain.smartcorn.model.RegisterResponse
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("/register")
    fun registerUser(@Body request: RegisterRequest?): Call<RegisterResponse?>?

    @POST("/login")
    fun loginUser(@Body request: LoginRequest?): Call<LoginResponse?>?
}