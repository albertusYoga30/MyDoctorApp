package com.example.mydoctor.ui.homeNavigation.hospitals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydoctor.databinding.AdapterHospitalsBinding
import com.example.mydoctor.model.hospital.HospitalModel

class AdapterHospitals(
    var data: List<HospitalModel>,
    val listener: EventListener
) :

    RecyclerView.Adapter<AdapterHospitals.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterHospitalsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(hospital: HospitalModel) {
            Glide.with(binding.root)
                .load(hospital.image)
                .into(binding.imageView)

            binding.hospitalName.text = hospital.title
            binding.hospitalAddress.text = hospital.address
            binding.root.setOnClickListener {
                listener.click(hospital)
            }
        }

    }

    fun update(data: List<HospitalModel>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterHospitalsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface EventListener {
        fun click(item: HospitalModel)
    }
}