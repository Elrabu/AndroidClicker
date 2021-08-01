package de.example.androidclicker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        button.setOnClickListener(listener)
    }

    val listener = View.OnClickListener { view ->
        when (view.getId()) {
            R.id.button -> {
                //  button.setText("Login")
                val intent = Intent(this, MainActivity2::class.java)
                // start your next activity
                startActivity(intent)
            }
        }
    }

}