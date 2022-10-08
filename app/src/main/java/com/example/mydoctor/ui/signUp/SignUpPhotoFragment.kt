package com.example.mydoctor.ui.signUp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentSignUpPhotoBinding


class SignUpPhotoFragment : Fragment() {

    companion object {
        fun newInstance() = SignUpPhotoFragment
    }

    private lateinit var binding: FragmentSignUpPhotoBinding

    private lateinit var viewModel: SignUpViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignUpPhotoBinding.inflate(layoutInflater)

        binding.back.setOnClickListener { this.findNavController().navigateUp() }
        binding.buttonUploadContinue.setOnClickListener { }
        binding.skip.setOnClickListener { signIn() }

        return binding.root
    }

    private fun signIn() {
        val action = SignUpPhotoFragmentDirections.actionSignUpPhotoFragmentToSignInFragment()
        this.findNavController().navigate(action)
    }
}
