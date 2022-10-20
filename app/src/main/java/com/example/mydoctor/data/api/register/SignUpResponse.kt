package com.example.mydoctor.data.api.register

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("name") val name: String,
    @SerializedName("email") val email: String,
    @SerializedName("job") val job: String,
    @SerializedName("image") val image: String,
)
