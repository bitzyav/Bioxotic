package trinidad.daniel.bioxotic

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.newFixedThreadPoolContext

class SingIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        val btn_sign_in : Button = findViewById(R.id.btn_sign_in)
        btn_sign_in.setOnClickListener{
            var signInIntent: Intent? = Intent(this, Menu_species::class.java)
            startActivity(signInIntent)
        }

        val forgotPassword:TextView= findViewById(R.id.text_forgot_password)
        forgotPassword.setOnClickListener {
            var signInIntent: Intent? = Intent(this, Request_email::class.java)
            startActivity(signInIntent)
        }

        val createOne:TextView= findViewById(R.id.text_create_one)
        createOne.setOnClickListener {
            var signInIntent: Intent? = Intent(this, SignUp::class.java)
            startActivity(signInIntent)
        }
    }
}