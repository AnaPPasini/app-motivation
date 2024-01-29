package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSave.setOnClickListener(this)

        supportActionBar?.hide()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_save) {
            print("Seja bem-vindo")
            handleSave()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }



    private fun handleSave () {

        //Salvar informação
        val name = binding.editYourName.text.toString()
        if (name != "") {

            //Salvando nome do usuario
            SecurityPreferences(this).storeString(MotivationConstants.KEY.USER_NAME, name)

            //Matar a activity
            finish()

        } else {
            //Criação e show (mostra)
            Toast.makeText(this, R.string.validation_mandatory_name, Toast.LENGTH_SHORT).show()

        }
    }

}
