package com.example.mydoctor.ui.homeNavigation.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mydoctor.data.api.home.HomeResponse
import com.example.mydoctor.databinding.AdapterGoodNewsBinding

class AdapterGoodNews(
    var data: List<HomeResponse.GoodNewsResponse>,


) : RecyclerView.Adapter<AdapterGoodNews.ViewHolder>() {

    inner class ViewHolder(val binding: AdapterGoodNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(goodNews: HomeResponse.GoodNewsResponse) {
            Glide.with(binding.root)
                .load(goodNews.image)
                .into(binding.imageGoodNews)

            binding.titleGoodNews.text = goodNews.title
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(data: List<HomeResponse.GoodNewsResponse>) {
        this.data = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterGoodNewsBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    interface EventListener {
        fun click(item: HomeResponse.GoodNewsResponse)
    }
}