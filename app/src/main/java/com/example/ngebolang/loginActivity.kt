package com.example.ngebolang


import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_login.*
import java.lang.reflect.Modifier
import android.content.Intent
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*



class loginActivity : AppCompatActivity() {
    private lateinit var xusername:EditText
    private lateinit var xpassword:EditText
    private lateinit var btn_login:Button
    private lateinit var reference: DatabaseReference
    private lateinit var showHideBtn: Button

    val USERNAME_KEY:String = "usernamekey"
    val username_key:String = ""

    private lateinit var sign_up : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        xusername = findViewById(R.id.xusername)
        xpassword = findViewById(R.id.xpassword)
        btn_login = findViewById(R.id.btn_login)
        showHideBtn = findViewById(R.id.showHideBtn)

        btn_login.setOnClickListener {
            onClick()
        }

        showHideBtn.setOnClickListener{
           onShow()
        }

        sign_up = findViewById(R.id.txt2_sign_up)

        sign_up.setOnClickListener {
            val go_sign_up = Intent(this, activity_signup::class.java)
            startActivity(go_sign_up)
        }

        btn_login.setOnClickListener(View.OnClickListener {
            onClick()
        })

    }

    fun onClick() {
        val username:String = xusername.text.toString()
        val password:String = xpassword.text.toString()
        reference = FirebaseDatabase.getInstance().getReference().child("users").child(username);
        reference.addListenerForSingleValueEvent(object :ValueEventListener{

            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()){
                    val passwordFromFirebase = dataSnapshot.child("password").getValue().toString()

                    if (password.equals(passwordFromFirebase)){
                        val sharedPreferences: SharedPreferences = getSharedPreferences(USERNAME_KEY, Context.MODE_PRIVATE)
                        val editor: SharedPreferences.Editor = sharedPreferences.edit()
                        editor.putString(username_key, xusername.text.toString())
                        editor.apply()
                        val intent = Intent(this@loginActivity,Home_Activity::class.java)
                        startActivity(intent)
                    }
                    else{
                        Toast.makeText(applicationContext, "password salah", Toast.LENGTH_SHORT).show()
                    }
                }
                else{
                    Toast.makeText(applicationContext, "username tidak ada", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                Toast.makeText(applicationContext, "Database Error", Toast.LENGTH_SHORT).show()
            }


        })
    }

    private fun onShow() {
        if(showHideBtn.text.toString().equals("")){
            xpassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
            showHideBtn.text = " "
        } else{
            xpassword.transformationMethod = PasswordTransformationMethod.getInstance()
            showHideBtn.text = ""
        }
    }

}
