package com.example.mydoctor.ui.homeNavigation.home

import android.content.SharedPreferences
import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydoctor.data.api.InterfaceAPI
import com.example.mydoctor.data.api.home.HomeResponse
import com.example.mydoctor.data.preference.Const
import com.example.mydoctor.model.home.UserProfileModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {

    private lateinit var interfaceAPI: InterfaceAPI
    val model: MutableLiveData<HomeResponse> = MutableLiveData()
    val userProfileModel: MutableLiveData<UserProfileModel> = MutableLiveData()

    fun onViewLoaded() {
        val userProfile = UserProfileModel(
            image = sharedPreferences.getString(Const.IMAGE, "") ?: "",
            name = sharedPreferences.getString(Const.FULL_NAME, "") ?: "",
            job = sharedPreferences.getString(Const.JOB, "") ?:""
        )

        userProfileModel.value = userProfile
        getDataFromAPI()
    }

    fun getDataFromAPI() {
        interfaceAPI = InterfaceAPI.getInstance().create(InterfaceAPI::class.java)

        CoroutineScope(Dispatchers.IO).launch {
            val response = interfaceAPI.getPageHome()

            withContext<Unit>(Dispatchers.Main) {
                if (response.isSuccessful) {
                    Log.d("getDataFromAPI()", response.body().toString())
                    println("Success get data from API")
                    model.value = response.body()
                } else {
                    Log.d("getDataFromAPI()", response.body().toString())
                    println("Failed get data from API")
                }
            }
        }
    }
}