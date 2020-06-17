package br.com.fiap.covida.model.chat.user

import br.com.fiap.covida.model.chat.ChatModel

open class ChatUserModel (
    val message: String
) : ChatModel(message)