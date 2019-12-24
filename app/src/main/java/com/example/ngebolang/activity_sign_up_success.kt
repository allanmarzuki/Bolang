package com.example.ngebolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class activity_sign_up_success : AppCompatActivity() {


    private lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up_success)
        handler = Handler()
        handler.postDelayed({
            intent = Intent(this@activity_sign_up_success, loginActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // 2000 Millis -> 2 Detik
    }
}
