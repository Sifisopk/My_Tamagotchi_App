package com.example.my_tamagotchi_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    private val HUNGER_CHANGE = 10
    private val CLEANLINESS_CHANGE = 10
    private val HEALTH_CHANGE = 10
    private val HUNGER_AFTER_PLAY = 5
    private val CLEANLINESS_AFTER_PLAY = -5

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


        hungryEditTxt.setText(petHunger.toString())
        cleanEditTxt.setText(petCleanliness.toString())
        happyEditTxt.setText(petCleanliness.toString())

        // code for what happens when the feed button is clicked
        feedBtn.setOnClickListener{
            petHunger  += HUNGER_CHANGE
            petHealth += HEALTH_CHANGE
            // Ensure attributes stay within bounds
            petHunger = petHunger.coerceIn(0, 100)
            petHealth = petHealth.coerceIn(0, 100)
            petCleanliness = petCleanliness.coerceIn(0, 100)
            hungryEditTxt.setText(petHunger.toString())
            happyEditTxt.setText(petHealth.toString())
            cleanEditTxt.setText(petCleanliness.toString())
            animatedImageChane(petImage, R.drawable.eating_pet)
        }

        // code for what happens when the clean button is clicked
        cleanBtn.setOnClickListener {
            petCleanliness += CLEANLINESS_CHANGE
            petHealth += HEALTH_CHANGE
            // Ensure attributes stay within bounds
            petCleanliness = petCleanliness.coerceIn(0, 100)
            petHealth = petHealth.coerceIn(0, 100)
            cleanEditTxt.setText(petCleanliness.toString())
            happyEditTxt.setText(petHealth.toString())
            animatedImageChane(petImage, R.drawable.clean_pet)
        }

        // code for what happens when the play button is clicked
        playBtn.setOnClickListener {
            petHunger -= HUNGER_AFTER_PLAY
            petCleanliness += CLEANLINESS_AFTER_PLAY
            // Ensure attributes stay within bounds
            petHealth = petHealth.coerceIn(0, 100)
            petHunger = petHunger.coerceIn(0, 100)
            petCleanliness = petCleanliness.coerceIn(0, 100)
            happyEditTxt.setText(petHealth.toString())
            hungryEditTxt.setText(petHunger.toString())
            cleanEditTxt.setText(petCleanliness.toString())
            animatedImageChane(petImage, R.drawable.playing_pet)
        }

    }

    //
    private fun animatedImageChane(imageView: ImageView, newImageResource: Int) {
        val  animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}