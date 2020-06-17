package br.com.fiap.covida.model.chat.bot

import br.com.fiap.covida.model.chat.ChatModel

open class ChatBotMessageModel (
    val message: String
) : ChatModel(message)