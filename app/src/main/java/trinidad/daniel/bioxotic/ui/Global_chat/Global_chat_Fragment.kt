package trinidad.daniel.bioxotic.ui.Global_chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import trinidad.daniel.bioxotic.R
import trinidad.daniel.bioxotic.ui.contact.ContactViewModel

class Global_chat_Fragment: Fragment()  {
    private lateinit var global_char_View_Model: ContactViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        global_char_View_Model =
            ViewModelProvider(this).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_global_chat, container, false)
        return root
    }


}