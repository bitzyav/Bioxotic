package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Request_code : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_code)

        val btn_change_password : Button = findViewById(R.id.btn_change_password)
        btn_change_password.setOnClickListener{
            var signInIntent: Intent? = Intent(this, SingIn::class.java)
            startActivity(signInIntent)
        }

    }
}