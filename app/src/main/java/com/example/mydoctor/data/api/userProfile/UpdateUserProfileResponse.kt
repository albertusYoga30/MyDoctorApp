package com.example.mydoctor.data.api.userProfile

import com.google.gson.annotations.SerializedName

data class UpdateUserProfileResponse(
    @SerializedName("name") var name : String,
    @SerializedName("email") var email : String,
    @SerializedName("job") var job : String,
    @SerializedName("image") var image : String
)