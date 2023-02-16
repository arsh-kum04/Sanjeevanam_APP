package com.example.sanjeevanam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.TextView
import com.airbnb.lottie.LottieAnimationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class splashscreen : AppCompatActivity() {
    private var tv:TextView?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        tv=findViewById(R.id.tv)
        val slideanimation=AnimationUtils.loadAnimation(this,R.anim.slideupanimation)
        tv?.startAnimation(slideanimation)


        CoroutineScope(Dispatchers.Main).launch {
            delay(4000L)
            startActivity(Intent(this@splashscreen, MainActivity::class.java))
            finish()
        }



    }
}