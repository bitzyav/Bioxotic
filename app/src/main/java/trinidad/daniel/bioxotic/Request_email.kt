package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Request_email : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_request_email)

        val btn_sign_in : Button = findViewById(R.id.btn_request_code)
        btn_sign_in.setOnClickListener{
            /*var signInIntent: Intent? = Intent(this, Request_code::class.java)
            startActivity(signInIntent)*/
        }
    }
}