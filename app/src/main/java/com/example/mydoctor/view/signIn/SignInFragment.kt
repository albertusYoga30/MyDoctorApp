package com.example.mydoctor.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentSignInBinding
import com.example.mydoctor.view.homeNavigation.HomeNavigationActivity
import com.example.mydoctor.viewModel.SignInViewModel

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        binding.textSignUp.setOnClickListener { signUp() }
        binding.buttonSignIn.setOnClickListener {
            val intent = Intent(activity, HomeNavigationActivity::class.java)
            activity?.startActivity(intent)
            activity?.finish()
        }

        return binding.root
    }

    private fun signUp() {
        val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
        this.findNavController().navigate(action)
    }
}