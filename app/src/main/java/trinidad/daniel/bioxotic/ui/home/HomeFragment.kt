package trinidad.daniel.bioxotic.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import trinidad.daniel.bioxotic.Menu_animal_species
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.SignIn

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val btn_sign_in : ImageButton = root.findViewById(R.id.ib_category_fishes)
        btn_sign_in.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, Menu_animal_species::class.java)
            startActivity(signInIntent)
        }

        val ib_back_login: ImageButton = root.findViewById(R.id.ib_back_login)
        ib_back_login.setOnClickListener{
            var signInIntent: Intent? = Intent(root.context, SignIn::class.java)
            startActivity(signInIntent)
        }
        return root
    }
}