package com.rivaldofez.chatlin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.rivaldofez.chatlin.databinding.ReceivedBinding
import com.rivaldofez.chatlin.databinding.SentBinding
import com.rivaldofez.chatlin.databinding.UserLayoutBinding
import com.rivaldofez.chatlin.model.Message
import com.rivaldofez.chatlin.model.User

class MessageAdapter(val context: Context, val messageList: ArrayList<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val ITEM_RECEIVE = 1
    private val ITEM_SENT = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == ITEM_RECEIVE){
            val messageLayoutBinding = ReceivedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return ReceivedViewHolder(messageLayoutBinding)
        }else{
            val messageLayoutBinding = SentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return SentViewHolder(messageLayoutBinding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentMessage = messageList[position]

        if(holder.javaClass == SentViewHolder::class.java){
            //do the stuff for sent view holder
            val viewHolder = holder as SentViewHolder
            viewHolder.bind(currentMessage)
        }else{
            //do stuff for received view holder
            val viewHolder = holder as ReceivedViewHolder
            viewHolder.bind(currentMessage)
        }
    }

    override fun getItemViewType(position: Int): Int {
        val currentMessage = messageList[position]

        return if(FirebaseAuth.getInstance().currentUser?.uid.equals(currentMessage.senderId)){
            ITEM_SENT
        }else{
            ITEM_RECEIVE
        }
    }

    override fun getItemCount(): Int = messageList.size
    class SentViewHolder(private val binding: SentBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(message: Message){
            with(binding){
                txtSentMessage.text = message.message
            }
        }
    }

    class ReceivedViewHolder(private val binding: ReceivedBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(message: Message){
            with(binding){
                txtReceivedMessage.text = message.message
            }
        }
    }
}