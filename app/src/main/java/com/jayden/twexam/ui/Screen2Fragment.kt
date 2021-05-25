package com.jayden.twexam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.jayden.twexam.R
import com.jayden.twexam.databinding.FragmentScreen1Binding
import com.jayden.twexam.databinding.FragmentScreen2Binding
import com.jayden.twexam.model.UserModel


class Screen2Fragment : Fragment() {

    private lateinit var binding: FragmentScreen2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_screen2,
            container,
            false
        )
        binding.userItem = arguments?.getSerializable("userItem") as UserModel.User?
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


}