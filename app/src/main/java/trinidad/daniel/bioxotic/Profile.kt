package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        supportActionBar?.hide()

        var ib_back_home: ImageButton = findViewById(R.id.ib_back_home)
        ib_back_home.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        var ib_logout: ImageButton = findViewById(R.id.ib_logout)
        ib_logout.setOnClickListener {
            Firebase.auth.signOut()
            val intent: Intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}