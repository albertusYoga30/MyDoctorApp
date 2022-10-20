package com.example.mydoctor.data.api.register

import com.google.gson.annotations.SerializedName

data class SignUpRequest(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("job") val job: String,
    @SerializedName("password") val password: String,
)
