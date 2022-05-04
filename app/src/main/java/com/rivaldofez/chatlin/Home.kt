package com.rivaldofez.chatlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rivaldofez.chatlin.databinding.ActivityHomeBinding
import com.rivaldofez.chatlin.model.User

class Home : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var userList: ArrayList<User>
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userList = ArrayList()
        adapter = UserAdapter(this, userList)
    }
}