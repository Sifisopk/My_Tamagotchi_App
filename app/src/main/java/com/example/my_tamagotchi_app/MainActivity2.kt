package com.example.my_tamagotchi_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    // Pet attributes
    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50
    private var petHappiness = 50

    // Constants for attribute changes
    private val hungerChange = 10
    private val cleanlinessChange = 10
    private val healthChange = 10
    private val hungerAfterPlay = 5
    private val cleanlinessAfterPlay = -5
    private val happinessChange = 10


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Declaring variables
        val feedBtn = findViewById<Button>(R.id.feed_Btn)
        val cleanBtn = findViewById<Button>(R.id.clean_Btn)
        val playBtn = findViewById<Button>(R.id.play_Btn)
        val hungryEditTxt = findViewById<EditText>(R.id.hungry_edit_txt)
        val cleanEditTxt = findViewById<EditText>(R.id.clean_edit_txt)
        val happyEditTxt = findViewById<EditText>(R.id.happy_edit_txt)
        val petImage =findViewById<ImageView>(R.id.pet_image)

        // Display initial values
        hungryEditTxt.setText(petHunger.toString())
        cleanEditTxt.setText(petCleanliness.toString())
        happyEditTxt.setText(petCleanliness.toString())

        // code for what happens when the feed button is clicked
        feedBtn.setOnClickListener{
            petHunger  += hungerChange
            petHealth += healthChange
            // Ensure attributes stay within bounds
            petHunger = petHunger.coerceIn(0, 100)
            petHealth = petHealth.coerceIn(0, 100)
            petCleanliness = petCleanliness.coerceIn(0, 100)
            hungryEditTxt.setText(petHunger.toString())
            cleanEditTxt.setText(petCleanliness.toString())
            animatedImageChange(petImage, R.drawable.eating_pet)
        }

        // code for what happens when the clean button is clicked
        cleanBtn.setOnClickListener {
            petCleanliness += cleanlinessChange
            petHealth += healthChange
            // Ensure attributes stay within bounds
            petCleanliness = petCleanliness.coerceIn(0, 100)
            petHealth = petHealth.coerceIn(0, 100)
            cleanEditTxt.setText(petCleanliness.toString())
            animatedImageChange(petImage, R.drawable.clean_pet)
        }

        // code for what happens when the play button is clicked
        playBtn.setOnClickListener {
            petHunger -= hungerAfterPlay
            petCleanliness += cleanlinessAfterPlay
            petHappiness += happinessChange
            petHealth += healthChange
            // Ensure attributes stay within bounds
            petHealth = petHealth.coerceIn(0, 100)
            petHunger = petHunger.coerceIn(0, 100)
            petCleanliness = petCleanliness.coerceIn(0, 100)
            petHappiness = petHappiness.coerceIn(0, 100)
            happyEditTxt.setText(petHappiness.toString())
            hungryEditTxt.setText(petHunger.toString())
            cleanEditTxt.setText(petCleanliness.toString())
            animatedImageChange(petImage, R.drawable.playing_pet)
        }

    }

    // function for changing the images when the buttons are clicked
    private fun animatedImageChange(imageView: ImageView, newImageResource: Int) {
        val  animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}