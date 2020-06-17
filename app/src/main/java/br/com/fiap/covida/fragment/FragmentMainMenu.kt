package br.com.fiap.covida.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.covida.R

class FragmentMainMenu: Fragment(R.layout.fragment_main_menu){

    lateinit var btnMainMenu: Button

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnMainMenu = view.findViewById(R.id.btnMainMenu)
        btnMainMenu.setOnClickListener { toBotsList() }
    }

    private fun toBotsList(){
        findNavController().navigate(R.id.action_fragmentMainMenu_to_fragmentBotsList)
    }
}