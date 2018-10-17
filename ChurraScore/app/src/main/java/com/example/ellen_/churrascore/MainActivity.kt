package com.example.ellen_.churrascore

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonPebolim.setOnClickListener {
            val intent = Intent(this, Pebolim::class.java)
            // start your next activity
            startActivity(intent)
        }

        buttonFutebol.setOnClickListener {
            val intent = Intent(this, Futebol::class.java)
            // start your next activity
            startActivity(intent)
        }

        buttonTruco.setOnClickListener {
            val intent = Intent(this, Truco::class.java)
            // start your next activity
            startActivity(intent)
        }
    }


}
