package com.jayden.twexam.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.jayden.twexam.databinding.ItemUserBinding
import com.jayden.twexam.model.UserModel


class UserRecyclerViewAdapter(
    private val context: Context,
    private val mListener: UserItemClickListener
) : ListAdapter<UserModel.User, UserListItemViewHolder>(UserItemDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserListItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(layoutInflater, parent, false)

        return UserListItemViewHolder(context, binding)
    }


    override fun onBindViewHolder(holder: UserListItemViewHolder, position: Int) {
        holder.bindTo(getItem(holder.adapterPosition))
        holder.binding.userItemClick = mListener
    }

}

class UserListItemViewHolder(private val context: Context, val binding: ItemUserBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindTo(
        user: UserModel.User
    ) {
        binding.userItem = user
        binding.executePendingBindings()
    }
}

private class UserItemDiffCallback : DiffUtil.ItemCallback<UserModel.User>() {
    override fun areItemsTheSame(
        oldItem: UserModel.User,
        newItem: UserModel.User
    ): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(
        oldItem: UserModel.User,
        newItem: UserModel.User
    ): Boolean =
        oldItem == newItem
}

interface UserItemClickListener {
    //For Onclick Purpose
    fun onUserItemClicked(userItem: UserModel.User)
}