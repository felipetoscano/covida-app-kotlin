package br.com.fiap.covida.adapter.holder

import android.view.View
import android.widget.TextView
import br.com.fiap.covida.R
import br.com.fiap.covida.model.chat.user.ChatUserModel

class ChatUserMessageViewHolder(itemView: View) : BaseViewHolder<ChatUserModel>(itemView) {

    private val txtChatUser = itemView.findViewById<TextView>(R.id.txtChatUser)

    override fun bind(item: ChatUserModel) {
        txtChatUser.text = item.message
    }
}