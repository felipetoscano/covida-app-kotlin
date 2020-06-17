package br.com.fiap.covida.adapter.holder

import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import br.com.fiap.covida.R
import br.com.fiap.covida.model.BotModel

class BotViewHolder(view: View, private val navController: NavController): BaseViewHolder<BotModel>(view){

    private val layout: LinearLayout = view.findViewById(R.id.layoutBots)
    private val txtBot: TextView = view.findViewById(R.id.txtBot)

    override fun bind(item: BotModel){
        txtBot.text = item.name
        layout.setOnClickListener { onClick(item) }
    }

    private fun onClick(item: BotModel){
        val bundle = bundleOf("bot" to item)
        navController.navigate(R.id.action_fragmentBotsList_to_fragmentChatbot, bundle)
    }
}