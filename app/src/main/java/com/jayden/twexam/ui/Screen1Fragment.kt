package com.jayden.twexam.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.jayden.twexam.R
import com.jayden.twexam.databinding.FragmentScreen1Binding
import com.jayden.twexam.util.JsonParserUtil

/**
 * A fragment representing a list of Items.
 */
class Screen1Fragment : Fragment() {


    private lateinit var binding: FragmentScreen1Binding
    private val viewModel: Screen1ViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_screen1,
            container,
            false
        )
        binding.viewmodel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUserList(this.requireContext())

    }
}