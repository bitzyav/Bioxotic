package trinidad.daniel.bioxotic.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_global_chat.*
import trinidad.daniel.bioxotic.Menu_animal_species
import trinidad.daniel.bioxotic.Profile
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.SignIn
import trinidad.daniel.bioxotic.ui.contact.ContactFragment

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()
        usuario.currentUser.email.toString()

        val ib_fishes : ImageButton = root.findViewById(R.id.ib_fishes)
        ib_fishes.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            if (signInIntent != null) {
                signInIntent.putExtra("category", "fishes")
            }
            startActivity(signInIntent)
        }

        val ib_birds : ImageButton = root.findViewById(R.id.ib_birds)
        ib_birds.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            if (signInIntent != null) {
                signInIntent.putExtra("category", "birds")
            }
            startActivity(signInIntent)
        }

        val ib_amphibians : ImageButton = root.findViewById(R.id.ib_amphibians)
        ib_amphibians.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            if (signInIntent != null) {
                signInIntent.putExtra("category", "amphibians")
            }
            startActivity(signInIntent)
        }

        val ib_felines : ImageButton = root.findViewById(R.id.ib_felines)
        ib_felines.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            if (signInIntent != null) {
                signInIntent.putExtra("category", "felines")
            }
            startActivity(signInIntent)
        }

        val ib_rodents : ImageButton = root.findViewById(R.id.ib_rodents)
        ib_rodents.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            if (signInIntent != null) {
                signInIntent.putExtra("category", "rodents")
            }
            startActivity(signInIntent)
        }

        val ib_reptiles : ImageButton = root.findViewById(R.id.ib_reptiles)
        ib_reptiles.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            if (signInIntent != null) {
                signInIntent.putExtra("category", "reptiles")
            }
            startActivity(signInIntent)
        }



        val button_user_profile: ImageButton = root.findViewById(R.id. ib_user_profile)
        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(root.context, Profile::class.java)
            startActivity(userProfileIntent)
        }
        return root
    }
}