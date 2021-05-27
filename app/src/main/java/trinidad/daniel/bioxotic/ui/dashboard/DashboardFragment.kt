package trinidad.daniel.bioxotic.ui.dashboard

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import trinidad.daniel.bioxotic.Profile
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.entities.Specie

class DashboardFragment : Fragment() {
    private lateinit var iv_img_desc: ImageView
    private lateinit var iv_image_description: ImageView
    private lateinit var tv_description: TextView

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
                ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.favorites_dashboard, container, false)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        iv_img_desc = root.findViewById(R.id.iv_img_desc_fav)
        iv_image_description = root.findViewById(R.id.iv_image_description_fav)
        tv_description = root.findViewById(R.id.tv_description_fav)

        val button_user_profile: ImageButton = root.findViewById(R.id.ib_user_profile)
        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(root.context, Profile::class.java)
            startActivity(userProfileIntent)
        }
        loadFavorite(root.context)
        return root
    }

    fun loadFavorite(context: Context) {

        storage.collection("favoritos").document(usuario.currentUser?.email.toString()).get().addOnSuccessListener {
             document->
            if(document.exists()){
                var image = document.getLong("image")?.toInt()
                var imageRec = document.getLong("imageRec")?.toInt()
                var name = document.getString("name").toString()
                var description = document.getString("description").toString()
                if (imageRec != null) {
                    iv_img_desc.setImageResource(imageRec)
                }
                if (image != null) {
                    iv_image_description.setImageResource(image)
                }
                tv_description.setText(description)
            }else{
                Toast.makeText(context, "The user has not seen any animals", Toast.LENGTH_SHORT).show()
            }
        }
    }
}