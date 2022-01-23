package com.example.asyncmessages

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.asyncmessages.databinding.MessageItemBinding

class Adapter(
    var messagesList: MutableList<Message>) :
    RecyclerView.Adapter<Adapter.Holder>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = MessageItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val message = messagesList[position]
        holder.bind(message)
    }

    override fun getItemCount(): Int {
        return messagesList.size
    }

    inner class Holder internal constructor(
        private val binding: MessageItemBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(message: Message) = binding.run {
            item.text = message.message
        }
    }
}


