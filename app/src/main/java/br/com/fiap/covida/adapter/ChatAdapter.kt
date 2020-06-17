package br.com.fiap.covida.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.covida.R
import br.com.fiap.covida.adapter.holder.BaseViewHolder
import br.com.fiap.covida.adapter.holder.ChatBotButtonViewHolder
import br.com.fiap.covida.adapter.holder.ChatBotMessageViewHolder
import br.com.fiap.covida.adapter.holder.ChatUserMessageViewHolder
import br.com.fiap.covida.model.chat.ChatModel
import br.com.fiap.covida.model.chat.bot.ChatBotButtonModel
import br.com.fiap.covida.model.chat.bot.ChatBotMessageModel
import br.com.fiap.covida.model.chat.user.ChatUserModel

class ChatAdapter: RecyclerView.Adapter<BaseViewHolder<*>>() {

    private val items = mutableListOf<ChatModel>()

    companion object {
        private const val TYPE_USER_MESSAGE = 0
        private const val TYPE_BOT_MESSAGE = 1
        private const val TYPE_BOT_BUTTON = 2
    }

    fun addItem(item: ChatModel){
        items.add(item)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when(viewType) {
            TYPE_USER_MESSAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_user, parent, false)
                ChatUserMessageViewHolder(view)
            }
            TYPE_BOT_MESSAGE -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_bot, parent, false)
                ChatBotMessageViewHolder(view)
            }
            TYPE_BOT_BUTTON -> {
                val view = LayoutInflater.from(parent.context).inflate(R.layout.item_chat_bot_button, parent, false)
                ChatBotButtonViewHolder(view, this)
            }
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val item = items[position]
        when (holder){
            is ChatUserMessageViewHolder -> holder.bind(item as ChatUserModel)
            is ChatBotMessageViewHolder -> holder.bind(item as ChatBotMessageModel)
            is ChatBotButtonViewHolder -> holder.bind(item as ChatBotButtonModel)
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is ChatUserModel -> TYPE_USER_MESSAGE
            is ChatBotMessageModel -> TYPE_BOT_MESSAGE
            is ChatBotButtonModel -> TYPE_BOT_BUTTON
            else -> throw IllegalArgumentException()
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }
}