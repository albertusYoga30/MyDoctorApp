package com.example.mydoctor.data.api.userProfile

import com.google.gson.annotations.SerializedName

data class UpdateUserProfileRequest(
    @SerializedName("name") var name : String? =null,
    @SerializedName("job") var job : String? =null,
    @SerializedName("image") var image : String? =null
)
