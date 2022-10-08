package com.example.mydoctor.view.signIn

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentSignInBinding
import com.example.mydoctor.view.homeNavigation.HomeNavigationActivity
import com.google.firebase.auth.FirebaseAuth

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var mAuth: FirebaseAuth
//    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater)
        mAuth = FirebaseAuth.getInstance()
        binding.textSignUp.setOnClickListener { signUp() }
        binding.buttonSignIn.setOnClickListener {

            val email = binding.inputEmailSignIn.text.toString()
            val password = binding.inputPasswordSignIn.text.toString()


            if (email.isEmpty()) {
                binding.inputEmailSignIn.error = "Email is required!"
                binding.inputEmailSignIn.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.inputEmailSignIn.error = "Please provide valid email!"
                binding.inputEmailSignIn.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.inputPasswordSignIn.error = "Password is required!"
                binding.inputPasswordSignIn.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.inputPasswordSignIn.error = "Min password length should be 6 character"
                binding.inputPasswordSignIn.requestFocus()
                return@setOnClickListener
            }

            loginUser(email, password)

        }

        return binding.root
    }

    private fun loginUser(email: String, password: String) {
////        mAuth.signInWithEmailAndPassword(email, password)
//            .addOnCompleteListener {
//                if (it.isSuccessful) {
                    Toast.makeText(context, "Login successful", Toast.LENGTH_SHORT).show()
                    goToHome()
//                } else {
//                    Toast.makeText(context, "Login failed", Toast.LENGTH_SHORT).show()
//                }
//            }
    }

    private fun signUp() {
        val action = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
        this.findNavController().navigate(action)
    }

    private fun goToHome() {
        val intent = Intent(activity, HomeNavigationActivity::class.java)
        activity?.startActivity(intent)
        activity?.finish()
    }
}