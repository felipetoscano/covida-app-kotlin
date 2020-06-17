package br.com.fiap.covida.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.covida.R
import br.com.fiap.covida.adapter.holder.BotViewHolder
import br.com.fiap.covida.model.BotModel

class BotAdapter: RecyclerView.Adapter<BotViewHolder>(){

    private var items = listOf<BotModel>()

    fun addItems(newItems: List<BotModel>){
        items =  newItems
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BotViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bot, parent, false)
        return BotViewHolder(view, parent.findNavController())
    }

    override fun onBindViewHolder(holder: BotViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }
}