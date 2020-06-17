package br.com.fiap.covida.fragment

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.fiap.covida.R
import br.com.fiap.covida.adapter.BotAdapter
import br.com.fiap.covida.service.BotService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FragmentBots: Fragment(R.layout.fragment_bots){

    lateinit var recyclerViewBots: RecyclerView
    private val botAdapter = BotAdapter()
    private val botService = BotService()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewBots = view.findViewById(R.id.recyclerViewBots)
        recyclerViewBots.adapter = botAdapter
        recyclerViewBots.layoutManager = LinearLayoutManager(activity)

        lifecycleScope.launch(Dispatchers.IO){
            val bots = botService.findAllAsync()

            withContext(Dispatchers.Main) {
                botAdapter.addItems(bots)
            }
        }
    }
}