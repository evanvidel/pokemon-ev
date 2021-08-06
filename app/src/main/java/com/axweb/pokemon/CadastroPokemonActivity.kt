package com.axweb.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axweb.pokemon.databinding.ActivityCadastroPokemonBinding


class CadastroPokemonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroPokemonBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroPokemonBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nome = intent.getStringExtra("nome")
        binding.textNome.text = "Ola, $nome"

        binding.btnNext.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}