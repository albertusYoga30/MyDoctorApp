package com.example.mydoctor.view.homeNavigation.ui.doctor

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentDoctorBinding
import com.example.mydoctor.view.homeNavigation.HomeNavigationActivity
import com.example.mydoctor.view.homeNavigation.ui.doctor.DoctorFragmentDirections
import com.example.mydoctor.view.signUp.SignUpFragmentDirections

class DoctorFragment : Fragment() {

    private lateinit var binding: FragmentDoctorBinding


    // This property is only valid between onCreateView and
    // onDestroyView.


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        binding = FragmentDoctorBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.userSection.setOnClickListener { profile()}
//        val textView: TextView = binding.textDashboard
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return binding.root
    }

    private fun profile() {
        val action = DoctorFragmentDirections.actionNavigationDoctorToProfile()
        this.findNavController().navigate(action)
    }
}