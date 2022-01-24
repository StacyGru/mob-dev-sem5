package com.example.asyncmessages

object Holder {

    private val messagesList = mutableListOf<Message>()

    fun addListItem(number: Int): MutableList<Message> {
        val item = "Сообщение ".plus(number)
        messagesList.add(Message(
            item
        ))
        return messagesList
    }
}