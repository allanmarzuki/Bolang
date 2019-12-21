package com.example.ngebolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*


class loginActivity : AppCompatActivity() {

    private lateinit var sign_up : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        sign_up = findViewById(R.id.txt2_sign_up)

        sign_up.setOnClickListener {
            val go_sign_up = Intent(this, activity_signup::class.java)
            startActivity(go_sign_up)
        }

        btn_login.setOnClickListener(View.OnClickListener {
            intent = Intent(this, Home_Activity::class.java)
            startActivity(intent)
        })

        //alangantitest
    }
}
