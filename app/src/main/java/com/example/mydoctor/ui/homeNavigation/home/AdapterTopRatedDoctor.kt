package com.example.mydoctor.ui.homeNavigation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydoctor.data.api.home.HomeResponse
import com.example.mydoctor.databinding.AdapterTopRatedDoctorBinding

class AdapterTopRatedDoctor(
    var data: List<HomeResponse.TopRatedDoctorResponse>

) : RecyclerView.Adapter<AdapterTopRatedDoctor.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterTopRatedDoctorBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(topRatedDoctors: HomeResponse.TopRatedDoctorResponse) {
            Glide.with(binding.root)
                .load(topRatedDoctors.image)
                .into(binding.doctorImage)

            binding.doctorName.text = topRatedDoctors.name
            binding.doctorSpecialist.text =topRatedDoctors.specialist
//            binding.doctorRate.rating = topRatedDoctors.rating

//            binding.imageOnline.visibility = if (topRateDoctors.isOnline) {
//                View.VISIBLE
//            }else {
//                View.GONE
//            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(data: List<HomeResponse.TopRatedDoctorResponse>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterTopRatedDoctorBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface EventListener {
        fun click(item: HomeResponse.TopRatedDoctorResponse)
    }
}