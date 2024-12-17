package com.agrisustain.smartcorn.utils

import com.agrisustain.smartcorn.data.api.ApiResponse
import com.agrisustain.smartcorn.data.api.LoginRequest
import com.agrisustain.smartcorn.data.api.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {
    @POST("register")
    suspend fun register(@Body registerRequest: RegisterRequest): ApiResponse<Any>

    @POST("login")
    suspend fun login(@Body loginRequest: LoginRequest): ApiResponse<Any>
}