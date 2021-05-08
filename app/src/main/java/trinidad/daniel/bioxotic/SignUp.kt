package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val btn_sign_up : Button = findViewById(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener{
            var signInIntent: Intent? = Intent(this, SignIn::class.java)
            startActivity(signInIntent)
        }

    }
}