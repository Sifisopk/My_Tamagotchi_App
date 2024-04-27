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

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

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

        feedBtn.setOnClickListener{
            petHunger -= 10
            petHealth += 10
            petHunger += 5
            hungryEditTxt.setText(petHunger.toString())
            animatedImageChane(petImage, R.drawable.eating_pet)
        }

        cleanBtn.setOnClickListener {
            petCleanliness += 10
            petHealth += 10
            cleanEditTxt.setText(petCleanliness.toString())
            animatedImageChane(petImage, R.drawable.clean_pet)
        }

        playBtn.setOnClickListener {
            petHealth += 10
            petHunger += 5
            petCleanliness -= 5
            happyEditTxt.setText(petHealth.toString())
            animatedImageChane(petImage, R.drawable.playing_pet)
        }

    }

    private fun animatedImageChane(imageView: ImageView, newImageResource: Int) {
        val  animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}