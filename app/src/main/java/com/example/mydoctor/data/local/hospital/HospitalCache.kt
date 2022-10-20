package com.example.mydoctor.data.local.hospital

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mydoctor.model.hospital.HospitalModel

@Entity(tableName = "Hospital")
data class HospitalCache(
    @PrimaryKey val id:String,
    val title:String,
    val image:String,
    val address:String,
){
    fun toModel(): HospitalModel {
        return HospitalModel(
            id = id,
            title = title,
            address = address,
            image = image
        )
    }
}