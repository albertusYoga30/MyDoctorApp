package com.example.mydoctor.ui.homeNavigation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.data.api.home.HomeResponse
import com.example.mydoctor.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.userSection.setOnClickListener { profilePage() }

        viewModel.userProfileModel.observe(viewLifecycleOwner) {
            binding.userName.text = it.name
            binding.userJob.text = it.job
        }

        val adapterConsultation = AdapterConsultation(listOf(),
            object : AdapterConsultation.EventListener {
                override fun click(item: HomeResponse.ConsultationResponse) {
                    Toast.makeText(
                        this@HomeFragment.context, "item.title", Toast.LENGTH_SHORT
                    ).show()
                }
            }
        )

        val adapterTopRatedDoctor =AdapterTopRatedDoctor(listOf())
        val adapterGoodNews =AdapterGoodNews(listOf())

        binding.recyclerviewConsultation.adapter = adapterConsultation
        binding.recyclerviewTopRatedDoctor.adapter = adapterTopRatedDoctor
        binding.recyclerviewGoodNews.adapter = adapterGoodNews

        return binding.root
    }

    private fun profilePage() {
        val action = HomeFragmentDirections.actionNavigationDoctorToProfile()
        this.findNavController().navigate(action)
    }
}