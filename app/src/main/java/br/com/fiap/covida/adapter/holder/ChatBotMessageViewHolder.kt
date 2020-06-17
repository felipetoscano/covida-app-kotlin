package br.com.fiap.covida.adapter.holder

import android.view.View
import android.widget.TextView
import br.com.fiap.covida.R
import br.com.fiap.covida.model.chat.bot.ChatBotMessageModel

class ChatBotMessageViewHolder(itemView: View) : BaseViewHolder<ChatBotMessageModel>(itemView) {

    private val txtChatBot = itemView.findViewById<TextView>(R.id.txtChatBot)

    override fun bind(item: ChatBotMessageModel) {
        txtChatBot.text = item.message
    }
}