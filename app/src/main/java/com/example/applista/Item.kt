package com.example.applista

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val detailTextView: TextView = findViewById(R.id.detailTextView)
        val detailDescriptionTextView: TextView = findViewById(R.id.detailDescriptionTextView)

        val intent = intent
        if (intent != null && intent.hasExtra("selectedString")) {
            val selectedString = intent.getStringExtra("selectedString")
            detailTextView.text = "Detalhes da String:"
            detailDescriptionTextView.text = selectedString
        }
    }
}
