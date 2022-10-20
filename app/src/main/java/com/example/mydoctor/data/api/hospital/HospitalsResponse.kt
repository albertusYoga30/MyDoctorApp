package com.example.mydoctor.data.api.hospital

import com.google.gson.annotations.SerializedName

data class HospitalsResponse(
    @SerializedName("hospital") val hospitals: List<HospitalResponse>
){
    data class HospitalResponse(
        @SerializedName("id") val id: String,
        @SerializedName("title") val title: String,
        @SerializedName("image") val image: String,
        @SerializedName("address") val address: String
    )
}
