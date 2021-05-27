package trinidad.daniel.bioxotic.ui.contact

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_global_chat.*
import kotlinx.android.synthetic.main.activity_hospital_contacts.*
import trinidad.daniel.bioxotic.Profile
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.entities.Hospital
import trinidad.daniel.bioxotic.entities.Specie

class ContactFragment: Fragment() {
    private lateinit var contactViewModel: ContactViewModel

    var hospitals = ArrayList<Hospital>()
    private lateinit var tv_hospital_name: TextView
    private lateinit var tv_contact_especialist: TextView
    private lateinit var et_name: EditText
    private lateinit var et_specie: EditText
    private lateinit var et_message: EditText

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactViewModel =
                ViewModelProvider(this).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_hospital_contacts, container, false)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        val button_user_profile: ImageButton = root.findViewById(R.id.ib_user_profile)
        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(root.context, Profile::class.java)
            startActivity(userProfileIntent)
        }

        val hospitalsList= listOf("Birds","Fishes", "Felines", "Reptiles", "Amphibians", "Rodents")

        tv_hospital_name = root.findViewById(R.id.tv_hospital_name)
        tv_contact_especialist=root.findViewById(R.id.tv_contact_especialist)
        et_name=root.findViewById(R.id.et_name)
        et_specie=root.findViewById(R.id.et_specie)
        et_message=root.findViewById(R.id.et_message)

        //Aquí se queda
        loadHospital()

        val adapterHospital= ArrayAdapter(root.context, android.R.layout.simple_spinner_item, hospitalsList)
        val spinner:Spinner = root.findViewById(R.id.spinner_f)
        spinner.adapter = adapterHospital

        spinner.onItemSelectedListener =object:
            AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                loadDataHospital(position)
            }
        }

        val button_send_message: Button= root.findViewById(R.id.button_send_message)
        button_send_message.setOnClickListener {
            sendMessage(root.context)
        }
        return root
    }

    fun sendMessage(context: Context) {
        val actividad = hashMapOf(
            "email" to usuario.currentUser.email.toString(),
            "name" to  et_name.text.toString(),
            "specie" to et_specie.text.toString(),
            "message" to et_message.text.toString(),
            "contact" to tv_hospital_name.text.toString()
        )
        storage.collection("hospital_contacts")
            .add(actividad)
            .addOnSuccessListener {
                Toast.makeText(context, "Message sent", Toast.LENGTH_SHORT).show()
                et_name.setText("")
                et_specie.setText("")
                et_message.setText("")
            }
            .addOnFailureListener{
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }
    }

    fun loadDataHospital(p: Int){
        tv_hospital_name.setText(hospitals.get(p).name)
        tv_contact_especialist.setText(hospitals.get(p).contact)
    }

    fun loadHospital() {
        hospitals.add(Hospital("VCA Animal Health Hospital", "Birds", "+1 520-885-2364"))
        hospitals.add(Hospital("Veterinary Specialty Hospital of San Diego", "Fishes", "+1 858-875-7500"))
        hospitals.add(Hospital("Central Mesa Veterinary Hosvpital", "Felines", "+1 480-964-9601"))
        hospitals.add(Hospital("Vista Hills Animal Hospital", "Reptiles", "+1 915-592-5867"))
        hospitals.add(Hospital("Casillas Veterinary Hospitals", "Amphibians", "+1 323-721-2244"))
        hospitals.add(Hospital("VCA Animal Health Hospital", "Rodents", "+1 915-832-0700"))
    }

}