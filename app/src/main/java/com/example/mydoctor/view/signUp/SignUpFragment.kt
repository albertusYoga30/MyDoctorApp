package com.example.mydoctor.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentSignUpBinding
import com.example.mydoctor.viewModel.SignUpViewModel
import com.google.firebase.auth.FirebaseAuth


class SignUpFragment : Fragment() {

    private var mAuth: FirebaseAuth? = null

    companion object {
        fun newInstance() = SignUpFragment()
    }

    private lateinit var viewModel: SignUpViewModel

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
        binding.back.setOnClickListener { this.findNavController().navigateUp() }
        binding.buttonContinue.setOnClickListener { uploadPhoto() }


        mAuth = FirebaseAuth.getInstance()
        return binding.root
    }

    private fun uploadPhoto() {
        val action = SignUpFragmentDirections.actionSignUpFragmentToSignUpPhotoFragment()
        this.findNavController().navigate(action)
    }


}