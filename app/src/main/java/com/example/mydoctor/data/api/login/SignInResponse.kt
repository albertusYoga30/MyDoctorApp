package com.example.mydoctor.data.api.login

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("user-token") val token: String,
    @SerializedName("objectId") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("job") val job: String,
    @SerializedName("image") val image: String,
)