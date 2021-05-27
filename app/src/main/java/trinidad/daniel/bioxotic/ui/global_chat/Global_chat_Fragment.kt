package trinidad.daniel.bioxotic.ui.global_chat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import io.grpc.util.GracefulSwitchLoadBalancer
import kotlinx.android.synthetic.main.activity_global_chat.*
import kotlinx.android.synthetic.main.activity_global_chat.user_msg
import kotlinx.android.synthetic.main.item_messages.*
import trinidad.daniel.bioxotic.MessagesAdapter
import trinidad.daniel.bioxotic.Profile
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.entities.Message

class Global_chat_Fragment: Fragment()  {

    private lateinit var global_chat_View_Model: GlobalViewModel

    private lateinit var storage: FirebaseFirestore
    private lateinit var usuario: FirebaseAuth
    private var adapter: MessagesAdapter? = null

    companion object{
        var messages = ArrayList<Message>()
        var first = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        global_chat_View_Model = ViewModelProvider(this).get(GlobalViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_global_chat, container, false)

        val button_user_profile: ImageButton = root.findViewById(R.id.ib_user_profile)

        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(root.context, Profile::class.java)
            startActivity(userProfileIntent)
        }

        var lv: ListView = root.findViewById(R.id.lv_messages)
        val img: ImageButton = root.findViewById(R.id.ib_send_message)

        storage = FirebaseFirestore.getInstance()
        usuario = FirebaseAuth.getInstance()

        img.setOnClickListener {
            val actividad = hashMapOf(
                "email" to usuario.currentUser.email.toString(),
                "text" to user_msg.text.toString()
            )

            storage.collection("chats")
                .add(actividad)
                .addOnSuccessListener {
                    Toast.makeText(root.context, "Message sent", Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener{
                    Toast.makeText(root.context, it.toString(), Toast.LENGTH_SHORT).show()
                }
        }

        if(first){
            showMssgs()
            first = false
        }

        adapter = MessagesAdapter(root.context, messages)
        lv.adapter = adapter
        Toast.makeText(context, messages.toString(), Toast.LENGTH_LONG).show()

        return root
    }

    fun showMssgs(){
        storage.collection("chats")
            .get()
            .addOnSuccessListener {
                it.forEach{

                    var email = it.getString("email")
                    val username = email!!.split("@")

                    var text = it.getString("text")

                    var msg = Message(username[0], text!!)

                    messages.add(msg)
                }

            }

            .addOnFailureListener{
                Toast.makeText(context, it.toString(), Toast.LENGTH_SHORT).show()
            }

    }

}