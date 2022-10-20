package com.example.mydoctor.data.api.messages

import com.google.gson.annotations.SerializedName

data class MessageListResponse(
    @SerializedName("message") val message: List<MessageResponse>
) {
    data class MessageResponse(
        @SerializedName("id") var id : String,
        @SerializedName("name") var name : String,
        @SerializedName("image") var image : String,
        @SerializedName("message") var message : String
    )
}