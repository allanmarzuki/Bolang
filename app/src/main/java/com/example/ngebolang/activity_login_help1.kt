package com.example.ngebolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class activity_login_help1 : AppCompatActivity() {

    private lateinit var help_next : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_help1)

        help_next = findViewById(R.id.next_help)

        help_next.setOnClickListener {
            val go_next_help = Intent(this, activity_login_help2::class.java)
            startActivity(go_next_help) }
    }
}
