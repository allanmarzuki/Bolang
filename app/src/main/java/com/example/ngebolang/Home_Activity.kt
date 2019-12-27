package com.example.ngebolang

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class Home_Activity : AppCompatActivity() {

    private lateinit var photo_profil : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_)

        photo_profil = findViewById(R.id.pict_photo_home_user)

        photo_profil.setOnClickListener{
            val goto_user_page = Intent(this, Edit_profile_Activity::class.java)
            startActivity(goto_user_page)
        }

    }
}
