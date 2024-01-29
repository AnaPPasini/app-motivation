package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.data.Mock
import com.example.motivation.infra.SecurityPreferences
import com.example.motivation.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.INCLUSIVE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        //Eventos
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageInclusive.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.textPhrase1.setOnClickListener(this)

        handleUserName()
        handleFilter(R.id.image_happy)
        handleNextPhrase()

        setContentView(binding.root)

        //Esconder a barra de navegação
        supportActionBar?.hide()

    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_New_Phrase) {
            handleNextPhrase()
        }

        else if (view.id in listOf(R.id.image_happy, R.id.image_sunny,R.id.image_inclusive)) {
            handleFilter(view.id)

        } else if (view.id == R.id.text_phrase1) {
            startActivity(Intent(this,UserActivity::class.java))
        }

    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        binding.textPhrase1.text = "Olá, $name!"

    }
    private fun handleFilter(id: Int) {

        binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageInclusive.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_happy -> {
                binding.imageHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.HAPPY
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY

            }
            R.id.image_inclusive -> {
                binding.imageInclusive.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.INCLUSIVE
            }
        }
    }
    private fun handleNextPhrase() {
        binding.textPhrase.text = Mock().getPhrase(categoryId, Locale.getDefault().language).toString()
    }
}