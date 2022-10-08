package com.example.mydoctor.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentGetStartedBinding
import com.example.mydoctor.ui.signIn.SignInFragment


class GetStartedFragment : Fragment() {

    private lateinit var binding: FragmentGetStartedBinding

    companion object {
        fun newInstance() = SignInFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGetStartedBinding.inflate(inflater, container, false)

        binding.btnGetStarted.setOnClickListener { signUp() }
        binding.btnSignIn.setOnClickListener { signIn() }

        return binding.root

    }

    private fun signIn() {
        val action = GetStartedFragmentDirections.actionGetStartedFragmentToSignInFragment()
        this.findNavController().navigate(action)
    }

    private fun signUp() {
        val action = GetStartedFragmentDirections.actionGetStartedFragmentToSignUpFragment()
        this.findNavController().navigate(action)
    }
}