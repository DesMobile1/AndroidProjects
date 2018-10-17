package com.example.ellen_.churrascore

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.activity_splash_screen.*

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        GlideApp.with(this)
                .load("https://banner2.kisspng.com/20180715/bex/kisspng-beach-volleyball-admu-lady-blue-spikers-sport-coac-youtube-playlist-icon-5b4aef5f8551a6.8539938915316375995461.jpg")
                .into(imgLogoApp)

        Handler().postDelayed({
            val listaContatinhos = Intent(this, MainActivity::class.java)
            startActivity(listaContatinhos)
            finish()
        }, 2000)

    }
}