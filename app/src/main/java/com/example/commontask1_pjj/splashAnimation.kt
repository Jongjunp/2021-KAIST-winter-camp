package com.example.commontask1_pjj

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class splashAnimation : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.animation)

        var loadingImage = findViewById<LottieAnimationView>(R.id.loading_anim)

        loadingImage.setAnimation(R.raw.opening_anim)
        loadingImage.playAnimation()
        val handler: Handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
            finish()
        }, 3000)
    }
}

