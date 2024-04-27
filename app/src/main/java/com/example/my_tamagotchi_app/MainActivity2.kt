package com.example.my_tamagotchi_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.my_tamagotchi_app.R

class MainActivity2 : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val feed_Btn = findViewById<Button>(R.id.feed_Btn)
        val clean_Btn = findViewById<Button>(R.id.clean_Btn)
        val play_Btn = findViewById<Button>(R.id.play_Btn)
        val hungry_edit_txt = findViewById<EditText>(R.id.hungry_edit_txt)
        val clean_edit_txt = findViewById<EditText>(R.id.clean_edit_txt)
        val happy_edit_txt = findViewById<EditText>(R.id.happy_edit_txt)
        val pet_image =findViewById<ImageView>(R.id.pet_image)


        hungry_edit_txt.setText(petHunger.toString())
        clean_edit_txt.setText(petCleanliness.toString())
        happy_edit_txt.setText(petCleanliness.toString())

        feed_Btn.setOnClickListener{
            petHunger -= 10
            petHealth += 10
            petHunger += 5
            hungry_edit_txt.setText(petHunger.toString())
            animatedImageChane(pet_image, R.drawable.eating_pet)
        }

        clean_Btn.setOnClickListener {
            petCleanliness += 10
            petHealth += 10
            clean_edit_txt.setText(petCleanliness.toString())
            animatedImageChane(pet_image, R.drawable.clean_pet)
        }

        play_Btn.setOnClickListener {
            petHealth += 10
            petHunger += 5
            petCleanliness -= 5
            happy_edit_txt.setText(petHealth.toString())
            animatedImageChane(pet_image, R.drawable.playing_pet)
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