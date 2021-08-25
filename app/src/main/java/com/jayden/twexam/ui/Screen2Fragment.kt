package com.jayden.twexam.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.jayden.twexam.R
import com.jayden.twexam.databinding.FragmentScreen2Binding
import com.jayden.shared.model.UserModel


class Screen2Fragment : Fragment() {

    private lateinit var binding: FragmentScreen2Binding
    private val viewModel: Screen2ViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_screen2,
            container,
            false
        )

        var listType = object : TypeToken<UserModel.User>() {}.type
        val user : UserModel.User = Gson().fromJson(arguments?.getString("userItem"), listType)
        binding.userItem =  user
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.screen2_option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_cancel -> {
                findNavController().popBackStack()
            }
            R.id.menu_save -> {
                if (isFormValidated()) {
                    //update the previous screen
                    viewModel.updateUserList(
                        binding.userItem!!.copy(
                            firstName = binding.etFirstname.text.toString(),
                            lastName = binding.etLastname.text.toString(),
                            phone = binding.etPhone.text.toString(),
                            email = binding.etEmail.text.toString()
                        )
                    )
                    findNavController().popBackStack()
                } else {
                    val imm =
                        requireContext().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                    imm.hideSoftInputFromWindow(requireView().windowToken, 0)
                    val mySnackbar = Snackbar.make(
                        this.requireView(),
                        "Please fill in all the form",
                        Snackbar.LENGTH_SHORT
                    )
                    mySnackbar.show()
                }
            }
        }
        return true
    }

    private fun isFormValidated(): Boolean {
        return binding.etFirstname.text.isNotEmpty()
                && binding.etLastname.text.isNotEmpty()
    }

}