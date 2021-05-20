package trinidad.daniel.bioxotic.ui.Global_chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_global_chat.*
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.ui.contact.ContactViewModel

class Global_chat_Fragment: Fragment()  {


    private lateinit var global_char_View_Model: ContactViewModel
    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        global_char_View_Model =
            ViewModelProvider(this).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_global_chat, container, false)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        //Send msg
        button_user.setOnClickListener {

            val actividad = hashMapOf(
                "email" to usuario.currentUser.email.toString(),
                "text" to user_msg.text.toString()
            )

            storage.collection("chats")
                .add(actividad)
                .addOnSuccessListener {
                    Toast.makeText(root.context, "Mensaje agregado", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(root.context, it.toString(), Toast.LENGTH_SHORT).show()
                }
        }

        return root
    }

}