package trinidad.daniel.bioxotic.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import trinidad.daniel.bioxotic.Menu_animal_species
import trinidad.daniel.bioxotic.R

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

        val fishes: Button = root.findViewById(R.id.ib_category_fishes)
        fishes.setOnClickListener {
            requireContext().let {
                it.startActivity(Intent(it, Menu_animal_species::class.java))
            }
        }

        val back: Button = root.findViewById(R.id.ib_back_login)
        back.setOnClickListener {
            requireContext().let {
                it.startActivity(Intent(it, Menu_animal_species::class.java))
            }
        }

        return root
    }
}