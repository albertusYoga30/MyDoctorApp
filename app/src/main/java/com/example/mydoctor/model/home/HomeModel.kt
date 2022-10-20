package com.example.mydoctor.model.home

data class HomeModel(
    var profile: UserProfileModel,
    var consultationList:List<ConsultationModel> = emptyList(),
    var topRatedDoctorsList:List<TopRatedDoctorModel> = emptyList(),
    var goodNewsList:List<GoodNewsModel> = emptyList(),
)
