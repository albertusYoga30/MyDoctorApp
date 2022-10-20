package com.example.mydoctor.data.api

import com.example.mydoctor.data.api.home.HomeResponse
import com.example.mydoctor.data.api.hospital.HospitalsResponse
import com.example.mydoctor.data.api.login.SignInRequest
import com.example.mydoctor.data.api.login.SignInResponse
import com.example.mydoctor.data.api.messages.MessageListResponse
import com.example.mydoctor.data.api.register.SignUpRequest
import com.example.mydoctor.data.api.register.SignUpResponse
import com.example.mydoctor.data.api.userProfile.UpdateUserProfileRequest
import com.example.mydoctor.data.api.userProfile.UpdateUserProfileResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*


interface InterfaceAPI {

    @POST("users/login")
    suspend fun postSignIn(@Body request: SignInRequest): Response<SignInResponse>

    @POST("users/register")
    suspend fun postSignUp(@Body request: SignUpRequest): Response<SignUpResponse>

    @GET("doctor")
    suspend fun getPageHome(): Response<HomeResponse>

    @GET("hospital")
    suspend fun getPageHospital(): Response<HospitalsResponse>

    @GET("message")
    suspend fun getPageMessage(): Response<MessageListResponse>

    @PUT("users/{id}")
    suspend fun updateProfile(
        @Header("user-token") token:String,
        @Path("id")id:String,
        @Body request:UpdateUserProfileRequest
    ):Response<UpdateUserProfileResponse>

    companion object {
        fun getInstance(): Retrofit {
            val logging = HttpLoggingInterceptor()
            logging.level = HttpLoggingInterceptor.Level.BODY
            val httpClient = OkHttpClient.Builder()
                .addInterceptor(logging)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://silkybranch.backendless.app/api/")
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}