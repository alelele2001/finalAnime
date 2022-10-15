package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    lateinit var diceImage: ImageView
    lateinit var diceImage1: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage1 = findViewById(R.id.dice_image1)


        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

//        val countUpButton: Button = findViewById(R.id.count_up_button)
//        countUpButton.setOnClickListener { countUp() }*/


    }

    private fun rollDice() {
//        Toast.makeText(this, "button clicked",
//            Toast.LENGTH_SHORT).show()
        diceImage.setImageResource(getRandomDiceImage())
        diceImage1.setImageResource(getRandomDiceImage())


    }


    private fun getRandomDiceImage(): Int {

        val randomInt = (1..6).random()

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

    }
}
    /*private fun countUp(){
        val resultText: TextView = findViewById(R.id.result_text)
        if (resultText.text.toString() == "Hello World!"){
            resultText.text == "1"
        }
        else if (resultText.text.toString() == "6"){}
        else {
            resultText.text = (resultText.text.toString().toInt()+1).toString()
        }

    }*/


