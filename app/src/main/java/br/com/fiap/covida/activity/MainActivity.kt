package br.com.fiap.covida.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.covida.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
    }
}
