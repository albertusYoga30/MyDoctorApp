package com.example.mydoctor.ui.homeNavigation.hospitals

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mydoctor.data.api.InterfaceAPI
import com.example.mydoctor.data.api.hospital.HospitalsResponse
import com.example.mydoctor.model.hospital.HospitalModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HospitalViewModel() : ViewModel() {
    val hospitalModel:MutableLiveData<List<HospitalModel>> = MutableLiveData()
    private lateinit var homeAPI: InterfaceAPI

    fun onViewLoaded(){
//        getDataFromAPI()
    }

//    fun getDataFromAPI() {
//        homeAPI = InterfaceAPI.getInstanceApiary().create(InterfaceAPI::class.java)
//        CoroutineScope(Dispatchers.IO).launch{
//
//            val response =homeAPI.getPageHospital()
//
//            withContext(Dispatchers.Main){
//                if (response.isSuccessful){
//                    Log.d("getPageHospital()", response.body().toString())
////                    hospitalModel.value =response.body()
////                    println("sukses panggil ke API")
//
////                    insertHospital(response.body())
//
//                }else{
//                    Log.d("getPageHospital()",response.body().toString())
//                    println("gagal memanggil API")
//                }
//            }
//        }
//    }

//    fun insertHospital(response: HospitalsResponse?){
//        response?.let {
//            CoroutineScope(Dispatchers.IO).launch {
//                val hospitals:List<HospitalCache> = it.hospitals.map { hospital->
//                    HospitalCache(
//                        id = hospital.id,
//                        title = hospital.title,
//                        image = hospital.image,
//                        address = hospital.address
//                    )
//                }
//
//                appDatabase.homeDAO().insertAllHospital(*hospitals.toTypedArray())
//
//                val hospitalCaches: List<HospitalCache> = appDatabase.homeDAO().getAllHospital()
//                withContext(Dispatchers.Main){
//                    hospitalModel.value = hospitalCaches.map {
//                        it.toModel()
//                    }
//                }
//            }
//        }
//    }
}
