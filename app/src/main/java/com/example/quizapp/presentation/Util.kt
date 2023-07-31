package com.example.quizapp.presentation

import android.content.Context
import android.widget.Toast
import java.util.Collections
import kotlin.random.Random

object Util {

    fun generateJumbledCharacters(ans:String):List<Char>{
        val word = "abcdefghijklmnopqrstuvwxyz"
        val random = Random(word.length)
        var scrambledListOfChar = mutableListOf<Char>()
        for (i in 0..4){
            val c = word[random.nextInt(word.length)]
            scrambledListOfChar.add(c)
        }
        val ansList = mutableListOf<Char>().apply {
            for(c in ans){
                add(c)
            }
        }
        ansList.shuffle()
        scrambledListOfChar.addAll(ansList)
        return scrambledListOfChar
    }

    fun showSuccessToast(msg:String,context:Context){
        Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
    }
}