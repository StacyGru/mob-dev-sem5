package com.example.asyncmessages

object Holder {

    private val messagesList = mutableListOf<Message>()

    init {
        messagesList.add(Message(
            "Сообщение 1"
        ))
        messagesList.add(Message(
            "Сообщение 2"
        ))
        messagesList.add(Message(
            "Сообщение 3"
        ))
        messagesList.add(Message(
            "Сообщение 4"
        ))
        messagesList.add(Message(
            "Сообщение 5"
        ))
    }

    fun getMessagesList(): MutableList<Message> {
        return messagesList
    }
}