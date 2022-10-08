package com.example.mydoctor.view.signUp

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentSignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class SignUpFragment : Fragment() {

    private lateinit var binding: FragmentSignUpBinding
    private lateinit var mAuth: FirebaseAuth
    private lateinit var databaseReference: DatabaseReference
//    private lateinit var viewModel: SignUpViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(layoutInflater)
//        mAuth = FirebaseAuth.getInstance()

        binding.back.setOnClickListener { this.findNavController().navigateUp() }

        binding.buttonContinue.setOnClickListener {
            val fullName = binding.inputFullName.text.toString()
            val job = binding.inputJob.text.toString()
            val email = binding.inputEmail.text.toString()
            val password = binding.inputPassword.text.toString()

            if (fullName.isEmpty()) {
                binding.inputFullName.error = "Full name is required!"
                binding.inputFullName.requestFocus()
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                binding.inputEmail.error = "Email is required!"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.inputEmail.error = "Please provide valid email!"
                binding.inputEmail.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.inputPassword.error = "Password is required!"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 6) {
                binding.inputPassword.error = "Min password length should be 6 character"
                binding.inputPassword.requestFocus()
                return@setOnClickListener
            }
            signUpPhoto()

//            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
//                if (it.isSuccessful) {
//                    databaseReference = FirebaseDatabase.getInstance().getReference("users")
//
//                    databaseReference.child(mAuth.uid.toString()).child("fullName").setValue(fullName)
//                    databaseReference.child(mAuth.uid.toString()).child("email").setValue(email)
//                    databaseReference.child(mAuth.uid.toString()).child("job").setValue(job)
//                    databaseReference.child(mAuth.uid.toString()).child("photo").setValue("")
//                    Toast.makeText(context, "successful create new account", Toast.LENGTH_SHORT)
//                        .show()
//                    signUpPhoto()
//                } else {
//                    Toast.makeText(context, "Failed create new account", Toast.LENGTH_SHORT)
//                        .show()
//                }
//            }
        }

        return binding.root
    }


    private fun signUpPhoto() {
        val action = SignUpFragmentDirections.actionSignUpFragmentToSignUpPhotoFragment()
        this.findNavController().navigate(action)
    }
}