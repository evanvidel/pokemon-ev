package com.axweb.pokemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.axweb.pokemon.databinding.ActivityCadastroNomeBinding

class CadastroNomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroNomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroNomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

       binding.btnNext.setOnClickListener {

           val nome = binding.editName.text.toString()

           val intent = Intent(this, CadastroPokemonActivity::class.java)
           intent.putExtra("nome", nome)
           startActivity(intent)
       }
    }
}