package com.example.mydoctor.ui.homeNavigation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydoctor.data.api.home.HomeResponse
import com.example.mydoctor.databinding.AdapterConsultationBinding

class AdapterConsultation(
    var data: List<HomeResponse.ConsultationResponse>,
    val listener: EventListener

) : RecyclerView.Adapter<AdapterConsultation.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterConsultationBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(consultation: HomeResponse.ConsultationResponse) {
            Glide.with(binding.root)
                .load(consultation.icon)
                .into(binding.icon)

            binding.title.text = consultation.title
            binding.root.setOnClickListener {
                listener.click(consultation)
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(data: List<HomeResponse.ConsultationResponse>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterConsultationBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface EventListener {
        fun click(item: HomeResponse.ConsultationResponse)
    }
}