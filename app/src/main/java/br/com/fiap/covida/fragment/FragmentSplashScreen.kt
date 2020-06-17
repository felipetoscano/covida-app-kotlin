package br.com.fiap.covida.fragment

import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import br.com.fiap.covida.R

class FragmentSplashScreen: Fragment(R.layout.fragment_splash_screen){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Handler().postDelayed({ toMainMenu() }, 2000)
    }

    private fun toMainMenu(){
        findNavController().navigate(R.id.action_fragmentSplashScreen_to_fragmentMainMenu)
    }
}