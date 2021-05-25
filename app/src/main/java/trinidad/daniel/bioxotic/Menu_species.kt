package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import kotlinx.android.synthetic.main.activity_principal.*

class Menu_species : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_species)

        val btn_sign_in : ImageButton = findViewById(R.id.ib_category_fishes)
        btn_sign_in.setOnClickListener{
            var signInIntent: Intent? = Intent(this, Menu_animal_species::class.java)
            startActivity(signInIntent)
        }

        val ib_back_login:ImageButton= findViewById(R.id.ib_back_login)
        ib_back_login.setOnClickListener{
            var signInIntent: Intent? = Intent(this, SignIn::class.java)
            startActivity(signInIntent)
        }
    }


}
