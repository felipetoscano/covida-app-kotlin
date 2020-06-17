package br.com.fiap.covida.fragment

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.covida.R
import br.com.fiap.covida.adapter.ChatAdapter
import br.com.fiap.covida.model.BotModel
import br.com.fiap.covida.model.chat.bot.ChatBotMessageModel
import br.com.fiap.covida.model.chat.user.ChatUserModel
import br.com.fiap.covida.service.SegmentService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentChat: Fragment(R.layout.fragment_chat){

    lateinit var recyclerViewChat: RecyclerView
    lateinit var edtChat: EditText
    lateinit var btnChat: ImageButton
    private val chatAdapter = ChatAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bot = arguments?.getSerializable("bot") as BotModel
        edtChat = view.findViewById(R.id.edtChat)
        btnChat = view.findViewById(R.id.btnChat)
        recyclerViewChat = view.findViewById(R.id.recyclerViewChat)
        recyclerViewChat.layoutManager = LinearLayoutManager(activity)
        recyclerViewChat.adapter = chatAdapter

        btnChat.setOnClickListener {
            sendMessage(bot)
        }

        initConversation(bot)
    }

    private fun initConversation(bot: BotModel){
        val welcomeMessage = ChatBotMessageModel(bot.welcomeMessage)
        val segmentService = SegmentService()
        lifecycleScope.launch(Dispatchers.IO){
            val segments = segmentService.getSegmentsByIdAsync(bot.id)

            withContext(Dispatchers.Main) {
                chatAdapter.addItem(welcomeMessage)
                segments.forEach { chatAdapter.addItem(it) }
            }
        }
    }

    private fun sendMessage(bot: BotModel){
        val message = edtChat.text.toString()
        edtChat.text.clear()
        chatAdapter.addItem(ChatUserModel(message))
        if("tchau".equals(message, true))
            chatAdapter.addItem(ChatBotMessageModel(bot.farewellMessage))
        else
            chatAdapter.addItem(ChatBotMessageModel(bot.defaultMessage))
    }
}