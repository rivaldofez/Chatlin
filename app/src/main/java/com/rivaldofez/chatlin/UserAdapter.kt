package com.rivaldofez.chatlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rivaldofez.chatlin.databinding.UserLayoutBinding
import com.rivaldofez.chatlin.model.User

class UserAdapter(val context: Context, val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userLayoutBinding = UserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(userLayoutBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser)
    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(private val binding: UserLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            with(binding){
                txtName.text = user.name
            }
        }
    }
}