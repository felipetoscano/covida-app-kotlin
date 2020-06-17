package br.com.fiap.covida.model.chat.bot

class ChatBotOptionModel(
    val idOption: Int,
    val nameOption: String,
    message: String
) : ChatBotButtonModel(message)