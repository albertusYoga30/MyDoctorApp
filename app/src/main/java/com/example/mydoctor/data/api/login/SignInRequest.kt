package com.example.mydoctor.data.api.login

import com.google.gson.annotations.SerializedName

data class SignInRequest (
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String
)