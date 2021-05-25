package com.jayden.twexam.ui

import android.content.Context
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.jayden.twexam.R
import com.jayden.twexam.databinding.FragmentScreen2Binding
import com.jayden.twexam.model.UserModel


class Screen2Fragment : Fragment() {

    private lateinit var binding: FragmentScreen2Binding

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
        binding.userItem = arguments?.getSerializable("userItem") as UserModel.User?
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
        return binding.etFirstname.text.isNotEmpty() && binding.etEmail.text.isNotEmpty()
                && binding.etLastname.text.isNotEmpty() && binding.etPhone.text.isNotEmpty()
    }

}