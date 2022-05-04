package com.rivaldofez.chatlin

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.rivaldofez.chatlin.databinding.UserLayoutBinding
import com.rivaldofez.chatlin.model.User

class UserAdapter(val context: Context, val userList: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val userLayoutBinding = UserLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(userLayoutBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]
        holder.bind(currentUser, context)
    }

    override fun getItemCount(): Int = userList.size

    class UserViewHolder(private val binding: UserLayoutBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(user: User, context: Context){
            with(binding){
                txtName.text = user.name
                itemView.setOnClickListener {
                    val intent = Intent(context, Chat::class.java)
                    intent.putExtra("name", user.name)
                    intent.putExtra("uid", user.uid)
                    context.startActivity(intent)
                }
            }
        }
    }
}