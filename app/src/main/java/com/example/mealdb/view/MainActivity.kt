package com.example.mealdb.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.example.mealdb.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.labelCategory.text="Meal Categories"
        val toolbar:Toolbar= binding.toolbar as Toolbar

        // using toolbar as ActionBar

        // using toolbar as ActionBar
        setSupportActionBar(toolbar)


    }
}

