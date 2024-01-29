package com.example.motivation.infra

import android.content.Context
import android.content.SharedPreferences

//SharedPreferences é um mini banco de dados das aplicações baseado em chave - valor
class SecurityPreferences (context: Context){

    private val security: SharedPreferences =
        context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str:String) {
        security.edit().putString(key,str).apply()

    }

    fun getString (key: String): String {
        return security.getString(key,"") ?: ""

    }
}