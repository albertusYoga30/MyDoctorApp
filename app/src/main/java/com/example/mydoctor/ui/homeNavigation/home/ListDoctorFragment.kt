package com.example.mydoctor.ui.homeNavigation.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mydoctor.R
import com.example.mydoctor.databinding.FragmentListDoctorBinding

class ListDoctorFragment : Fragment() {
    private lateinit var binding: FragmentListDoctorBinding

    companion object {
        fun newInstance() = ListDoctorFragment()
    }

    private lateinit var viewModel: ListDoctorViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_doctor, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListDoctorViewModel::class.java)
        // TODO: Use the ViewModel
    }

}