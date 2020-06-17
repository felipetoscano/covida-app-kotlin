package br.com.fiap.covida.adapter.holder

import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import br.com.fiap.covida.R
import br.com.fiap.covida.activity.MainActivity
import br.com.fiap.covida.adapter.ChatAdapter
import br.com.fiap.covida.model.chat.bot.ChatBotButtonModel
import br.com.fiap.covida.model.chat.bot.ChatBotMessageModel
import br.com.fiap.covida.model.chat.bot.ChatBotOptionModel
import br.com.fiap.covida.model.chat.bot.ChatBotSegmentModel
import br.com.fiap.covida.model.chat.user.ChatUserModel
import br.com.fiap.covida.service.OptionService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChatBotButtonViewHolder (itemView: View, private val adapter: ChatAdapter) : BaseViewHolder<ChatBotButtonModel>(itemView) {

    private val txtChatBot = itemView.findViewById<TextView>(R.id.txtChatBot)
    private val layoutChatButton = itemView.findViewById<LinearLayout>(R.id.layoutChatButton)
    private val optionService = OptionService()

    override fun bind(item: ChatBotButtonModel) {
        when (item) {
            is ChatBotSegmentModel -> segmentButton(item)
            is ChatBotOptionModel -> optionButton(item)
        }
    }

    private fun segmentButton(item: ChatBotSegmentModel) {
        val context = (itemView.context as MainActivity)
        txtChatBot.text = item.name
        layoutChatButton.setOnClickListener {
            context.lifecycleScope.launch(Dispatchers.IO){
                val options = optionService.getOptionsByIdAsync(item.id)

                withContext(Dispatchers.Main) {
                    adapter.addItem(ChatUserModel(item.name))
                    options.forEach { adapter.addItem(it) }
                }
            }

        }
    }

    private fun optionButton(item: ChatBotOptionModel){
        txtChatBot.text = item.nameOption
        layoutChatButton.setOnClickListener {
            adapter.addItem(ChatUserModel(item.nameOption))
            adapter.addItem(ChatBotMessageModel(item.message))
        }
    }
}