package com.agrisustain.smartcorn.data.api

import com.google.gson.annotations.SerializedName

data class RegisterRequest(
    @SerializedName("first_name") val firstName: String,
    @SerializedName("last_name") val lastName: String,
    @SerializedName("email") val email: String,
    @SerializedName("password") val password: String,
    @SerializedName("city") val city: String,
    @SerializedName("province") val province: String,
    @SerializedName("country") val country: String,
    @SerializedName("age") val age: Int
)
data class LoginRequest(
    val email: String,
    val password: String
)
data class ApiResponse<T>(
    val success: Boolean,
    val message: String,
//    val data: T?,
    val token: String? // Token disimpan langsung di dalam ApiResponse
)

data class UserResponse(
    val id: Int,
    val firstName: String,
    val email: String,
    val token: String
)
data class LoginResponse(
    val token: String
)
