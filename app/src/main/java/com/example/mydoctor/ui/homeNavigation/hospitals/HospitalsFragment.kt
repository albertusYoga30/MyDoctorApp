package com.example.mydoctor.ui.homeNavigation.hospitals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.mydoctor.databinding.FragmentHospitalsBinding
import com.example.mydoctor.model.hospital.HospitalModel

class HospitalsFragment : Fragment() {

    private lateinit var viewModel: HospitalViewModel
    private lateinit var binding: FragmentHospitalsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHospitalsBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val adapterHospital = AdapterHospitals(listOf(),
            object : AdapterHospitals.EventListener {
                override fun click(item: HospitalModel) {
                    Toast.makeText(
                        context, item.title,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            })
//
//        binding.recyclerviewHospitals.adapter = adapterHospital
//        viewModel.onViewLoaded()

//        viewModel.hospitalModel.observe(viewLifecycleOwner) {
//            adapterHospital.update(it)
//
////            val count = adapterHospital.itemCount
//            binding.hospitalsCount.text = "${it.count()} tersedia"
//        }
        return root
    }

}