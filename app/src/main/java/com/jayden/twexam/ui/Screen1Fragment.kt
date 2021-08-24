package com.jayden.twexam.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jayden.shared.Greeting
import com.jayden.twexam.R
import com.jayden.twexam.databinding.FragmentScreen1Binding
import com.jayden.shared.model.UserModel

/**
 * A fragment representing a list of Items.
 */
class Screen1Fragment : Fragment() {


    private lateinit var binding: FragmentScreen1Binding
    private val viewModel: Screen1ViewModel by viewModels()
    private lateinit var userListAdapter: UserRecyclerViewAdapter

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
        Log.i("Screen1Fragment", "Hello from shared module: " + (Greeting().greeting()))
        viewModel.getGithubMembers()
        userListAdapter = UserRecyclerViewAdapter(
            this.requireContext(), object : UserItemClickListener {
                override fun onUserItemClicked(userItem: UserModel.User) {
                    findNavController().navigate(
                        R.id.action_screen1Fragment_to_screen2Fragment,
                        bundleOf("userItem" to userItem)
                    )
                }
            }
        )

        binding.rvUser.apply {
            this.adapter = userListAdapter
        }

        viewModel.userListResData.observe(viewLifecycleOwner, Observer{
            userListAdapter.submitList(viewModel.userListData)
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getUserList(this.requireContext())
    }
}