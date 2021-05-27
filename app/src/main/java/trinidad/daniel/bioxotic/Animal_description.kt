package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import trinidad.daniel.bioxotic.entities.Specie

class Animal_description : AppCompatActivity() {
    private lateinit var iv_img_desc: ImageView
    private lateinit var iv_image_description: ImageView
    private lateinit var tv_description: TextView

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_description)
        supportActionBar?.hide()

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        iv_img_desc = findViewById(R.id.iv_img_desc)
        iv_image_description = findViewById(R.id.iv_image_description)
        tv_description = findViewById(R.id.tv_description)

        val intent: Intent = getIntent()

        val image = intent.getIntExtra("image", 0)
        val imageRec = intent.getIntExtra("imageRec", 0)
        val name = intent.getStringExtra("name")
        val description = intent.getStringExtra("description")
        val category = intent.getStringExtra("category")

        iv_img_desc.setImageResource(imageRec)
        iv_image_description.setImageResource(image)
        tv_description.setText(description)

        val ib_back: ImageButton = findViewById(R.id.ib_back_menu_animal_species)
        ib_back.setOnClickListener {
            var signIntent: Intent? = Intent(this, Menu_animal_species::class.java)
            if (signIntent != null) {
                signIntent.putExtra("category", category)
            }
            startActivity(signIntent)
        }

        val button_user_profile: ImageButton = findViewById(R.id.ib_user_profile)
        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(this, Profile::class.java)
            startActivity(userProfileIntent)
        }

        saveLast(image, imageRec, name.toString(), description.toString())
    }

    fun saveLast(image: Int,imageRec:Int, name: String, description: String) {
        val favoritosRef: DocumentReference = storage.collection("favoritos")
            .document(usuario.currentUser?.email.toString())
        val afirmacion = hashMapOf(
            "image" to image,
            "imageRec" to imageRec,
            "name" to name,
            "description" to description
        )
        favoritosRef.set(afirmacion)
    }

}