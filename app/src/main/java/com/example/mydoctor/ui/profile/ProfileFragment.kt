package com.example.mydoctor.ui.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    companion object {
        fun newInstance() = ProfileFragment()
    }

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)

        binding.backNav.setOnClickListener { this.findNavController().navigateUp() }

        binding.editProfileSection.setOnClickListener { editProfile() }

        return binding.root
    }

    private fun editProfile(){
        val action = ProfileFragmentDirections.actionProfileToEditProfileFragment()
        this.findNavController().navigate(action)

    }

}