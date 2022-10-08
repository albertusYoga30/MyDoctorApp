package com.example.mydoctor.data

data class User(
    val fullName: String,
    val job: String,
    val email: String,
    val picture: String? =null
)