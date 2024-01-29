package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase (val description: String, val categoryId: Int, val lang: String)

class Mock {

    private val happy = MotivationConstants.FILTER.HAPPY
    private val sunny = MotivationConstants.FILTER.SUNNY
    private val inclusive = MotivationConstants.FILTER.INCLUSIVE
    private val PT = MotivationConstants.LANGUAGE.PT
    private val English = MotivationConstants.LANGUAGE.English
    private val French = MotivationConstants.LANGUAGE.French

    private val mListPhrase: List<Phrase> = listOf(

        Phrase("Não sabendo que era impossível, foi lá e fez.", happy, PT),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy, PT),
        Phrase("Quando está mais escuro, vemos mais estrelas!", happy,PT),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", happy,PT),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy,PT),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", happy,PT),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", sunny,PT),
        Phrase("Você perde todas as chances que você não aproveita.", sunny,PT),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", sunny,PT),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", sunny,PT),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", sunny,PT),
        Phrase("Se você acredita, faz toda a diferença.", sunny,PT),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", sunny,PT)
    )


    fun getPhrase (value: Int, lang: String): String {
        val filtered = mListPhrase.filter { (it.categoryId == value || value == inclusive)
                && it.lang == lang}
        return filtered[Random.nextInt(filtered.size)].description
    }

}