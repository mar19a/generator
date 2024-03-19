package com.example.generator

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.core.content.ContextCompat
import com.example.generator.databinding.ActivityMainBinding
import java.util.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    private var currentImageName: String? = "Purple"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBinding()
        initSharedPreferences()
        loadInitialState()
        setupImageChangeListener()
    }

    private fun initBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun initSharedPreferences() {
        sharedPreferences = getPreferences(Context.MODE_PRIVATE)
    }

    // Load initial state from SharedPreferences
    private fun loadInitialState() {
        currentImageName = sharedPreferences.getString("image_name", "Purple")
        updateImage(currentImageName)
        updateTitle(sharedPreferences.getString("image_title", "Random Image"))
    }

    // Set the image and title based on the current image name
    private fun updateImage(name: String?) {
        binding.imageContent.setImageDrawable(
            ContextCompat.getDrawable(
                this, when (name) {
                    "City" -> R.drawable.supracity
                    "Dark" -> R.drawable.supradark
                    "Under Bridge" -> R.drawable.supragreen
                    "Purple" -> R.drawable.suprapurple
                    "Train Tracks" -> R.drawable.supratrain
                    else -> R.drawable.supracity
                }
            )
        )
    }

    private fun updateTitle(title: String?) {
        binding.textInfo.text = Editable.Factory.getInstance().newEditable(title)
    }

    // Set up the button click listener to change the image randomly
    private fun setupImageChangeListener() {
        binding.selectImgButton.setOnClickListener {
            val random = Random()
            val randomNumber = random.nextInt(5)
            val imageName = arrayOf("City", "Dark", "Under Bridge", "Purple", "Train Tracks")[randomNumber]
            currentImageName = imageName
            updateImage(imageName)
            updateTitle(imageName)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        with(sharedPreferences.edit()) {
            putString("image_title", binding.textInfo.text.toString())
            putString("image_name", currentImageName)
            apply()
        }
    }
}
