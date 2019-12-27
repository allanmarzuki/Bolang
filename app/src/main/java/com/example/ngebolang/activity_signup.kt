package com.example.ngebolang

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.*

class activity_signup : AppCompatActivity() {

    private lateinit var btn_signup : ImageView
    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var email_address : EditText
    private lateinit var nama : EditText
    private lateinit var reference : DatabaseReference
    private lateinit var txtsign_in: ImageView

    val USERNAME_KEY:String = "usernamekey"
    val username_key:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        btn_signup = findViewById(R.id.btn_signup)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        email_address = findViewById(R.id.email_address)
        nama = findViewById(R.id.nama)
        txtsign_in = findViewById(R.id.txtsign_in)

        btn_signup.setOnClickListener {
            onClick()
        }

        txtsign_in.setOnClickListener{
            onSignin()
        }
    }

    fun onClick(){
        val sharedPreferences: SharedPreferences = getSharedPreferences(USERNAME_KEY, Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString(username_key, username.text.toString())
        editor.apply()

        val xuser:String = username.text.toString()
        val xpass:String = password.text.toString()
        val xnama:String = nama.text.toString()
        val xemail:String = email_address.text.toString()

        if (xuser.isEmpty()||xpass.isEmpty()||xnama.isEmpty()||xemail.isEmpty()){
            Toast.makeText(applicationContext, "Data incomplete, please check again.", Toast.LENGTH_SHORT).show()
        }
        else{
            reference = FirebaseDatabase.getInstance().getReference().child("users").child(username.text.toString())
            reference.addListenerForSingleValueEvent(object :ValueEventListener{

                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    dataSnapshot.ref.child("username").setValue(xuser)
                    dataSnapshot.ref.child("password").setValue(xpass)
                    dataSnapshot.ref.child("email_address").setValue(xemail)
                    dataSnapshot.ref.child("nama").setValue(xnama)
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }

            })

            val intent = Intent(this@activity_signup,activity_sign_up_success::class.java)
            startActivity(intent)


        }


    }

    fun onSignin(){
        val signin = Intent(this@activity_signup,loginActivity::class.java)
        startActivity(signin)
    }
}
