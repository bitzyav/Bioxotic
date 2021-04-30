package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Animal_description : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_description)
        
        val ib_back: ImageButton = findViewById(R.id.ib_back_menu_animal_species)
        ib_back.setOnClickListener{
            var signInIntent: Intent? = Intent(this, Menu_animal_species::class.java)
            startActivity(signInIntent)
        }
    }


}