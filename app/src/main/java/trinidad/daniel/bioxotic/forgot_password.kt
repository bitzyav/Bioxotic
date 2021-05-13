package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton

class forgot_password : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        val btn_find_your_account: Button = findViewById(R.id.btn_find_your_account)
        btn_find_your_account.setOnClickListener{
            var signInIntent: Intent? = Intent(this, SingIn::class.java)
            startActivity(signInIntent)
        }
    }

}