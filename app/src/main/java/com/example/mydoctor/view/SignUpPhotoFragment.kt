package com.example.mydoctor.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.mydoctor.databinding.FragmentSignUpPhotoBinding
import com.example.mydoctor.viewModel.SignUpViewModel


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
        binding.skip.setOnClickListener {
            Toast.makeText(context, "nice progress", Toast.LENGTH_LONG).show()
        }

        return binding.root
    }
}
