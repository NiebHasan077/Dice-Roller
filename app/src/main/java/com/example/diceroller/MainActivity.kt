package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

/**
 * This is the activity that allows the app to roll a dice and see a number as output
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Here we the button to be clickable and reactive on a click
        val rollButton: Button = findViewById(R.id.button2)
        rollButton.setOnClickListener { rollDice() }

        // A default rollDice to set the initial screen
        rollDice()
    }

    /**
     * This method implements the rolling operation of the dice
     */
    private fun rollDice() {
        val dice = Dice(6)
        val diceRoll = dice.roll()

        val diceImage: ImageView = findViewById(R.id.imageView)

        /**
         * The when statement is for selecting the correct ImageView according to the diceRoll
         */
        val drawableResource = when(diceRoll)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Finally we set the correct id of the image
        diceImage.setImageResource(drawableResource)

        //Description of the content for visual assistant
        diceImage.contentDescription = diceRoll.toString()

    }
}

/**
 * This is the dice class that describes a piece of dice and it's attributes and functionalities
 */
class Dice(private val numSides: Int) {
    fun roll(): Int {
        return (1..numSides).random()
    }
}