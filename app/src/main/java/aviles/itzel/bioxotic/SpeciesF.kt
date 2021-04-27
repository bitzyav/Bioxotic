package aviles.itzel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class SpeciesF : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_species_f2)

        val ib_category : ImageButton = findViewById(R.id.ib_category)

        ib_category.setOnClickListener{
            val signInIntent: Intent? = Intent(this, Menu_animals_species::class.java)
            startActivity(signInIntent)
        }






    }



}