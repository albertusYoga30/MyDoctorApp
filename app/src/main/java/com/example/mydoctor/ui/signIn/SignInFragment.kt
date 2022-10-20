package com.example.mydoctor.ui.signIn

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Patterns
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.data.preference.Const
import com.example.mydoctor.databinding.FragmentSignInBinding
import com.example.mydoctor.ui.homeNavigation.HomeNavigationActivity

class SignInFragment : Fragment() {
    private lateinit var binding: FragmentSignInBinding
    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(layoutInflater, container, false)
        val root: View = binding.root

        val sharedPreferences: SharedPreferences =
            requireContext().getSharedPreferences(Const.PREF_NAME, Context.MODE_PRIVATE)

        viewModel = SignInViewModel(sharedPreferences)

        viewModel.isButtonEnable.observe(viewLifecycleOwner) { binding.buttonSignIn.isEnabled = it }

        binding.inputEmailSignIn.doAfterTextChanged {
            val email = it.toString()
            viewModel.onChangeEmail(email)
        }

        binding.etPassword.doAfterTextChanged {
            val password = it.toString()
            viewModel.onChangePassword(password)
        }

        binding.buttonSignIn.setOnClickListener {

            val email = binding.inputEmailSignIn.text.toString()
            val password = binding.etPassword.text.toString()

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
                binding.etPassword.error = "Password is required!"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.etPassword.error = "Min password length should be 6 character"
                binding.etPassword.requestFocus()
                return@setOnClickListener
            }

            loginUser()

        }
        binding.textSignUp.setOnClickListener { signUp() }
        return root
    }

    private fun loginUser() {
        viewModel.doSignIn()
        goToHome()
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