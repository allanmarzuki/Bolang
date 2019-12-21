package com.example.ngebolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class activity_signup : AppCompatActivity() {

    private lateinit var sign_in : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        sign_in = findViewById(R.id.txtsign_in)

        sign_in.setOnClickListener {
            val go_sign_in = Intent(this, loginActivity::class.java)
            startActivity(go_sign_in)
        }
    }
}
