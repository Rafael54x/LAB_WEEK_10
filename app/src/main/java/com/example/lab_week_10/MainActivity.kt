package com.example.lab_week_10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.lab_week_10.viewmodels.TotalViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy {
        ViewModelProvider(this)[TotalViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val totalTextView = findViewById<TextView>(R.id.text_total)
        val incrementButton = findViewById<Button>(R.id.button_increment)

        // Observe the LiveData from the ViewModel to update the UI
        viewModel.total.observe(this) { newTotal ->
            totalTextView.text = getString(R.string.text_total, newTotal)
        }

        // Set the click listener to update the data in the ViewModel
        incrementButton.setOnClickListener {
            viewModel.incrementTotal()
        }
    }
}
