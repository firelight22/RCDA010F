package com.example.tpvraioufaux

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.tpvraioufaux.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var amb : ActivityMainBinding
    val alqr = arrayListOf<QuestionReponse>(
        QuestionReponse("Est-ce que les coccinnelles bleues existent",true),
        QuestionReponse("Mc Do est bon pour la santé",false),
        QuestionReponse("Est-il possible de manger sous l'eau",false),
        QuestionReponse("Nous produisons 1.5l de salive par jour",true),
        QuestionReponse("Il y a plus d'arbres sur terre que d'étoile dans la voie lactée",true),
        QuestionReponse("La pogonophobie est la peur des développeurs",false),
    )
    var score = 0
    var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        amb = DataBindingUtil.setContentView(this,R.layout.activity_main)
        amb.questionReponse = alqr[index]
        amb.buttonTrue.setOnClickListener { checkResponse(true) }
        amb.buttonFalse.setOnClickListener { checkResponse(false) }
    }
    fun checkResponse(userResponse : Boolean){
        if(index > alqr.lastIndex)
            return
        if(alqr[index].reponse ==userResponse){
            score ++
            amb.score = score
        }
        nextQuestion()
    }

    fun nextQuestion(){
        val indexMaxQR = alqr.size -1
        if(++index <= indexMaxQR){
            amb.questionReponse = alqr[index]
        }else
            Toast.makeText(this,
                "Fin du questionnaire, votre score est de $score",
                Toast.LENGTH_SHORT).show()
    }
}