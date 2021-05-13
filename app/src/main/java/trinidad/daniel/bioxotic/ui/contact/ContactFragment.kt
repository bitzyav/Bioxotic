package trinidad.daniel.bioxotic.ui.contact

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import trinidad.daniel.bioxotic.R

class ContactFragment: Fragment() {
    private lateinit var contactViewModel: ContactViewModel
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        contactViewModel =
                ViewModelProvider(this).get(ContactViewModel::class.java)
        val root = inflater.inflate(R.layout.activity_hospital_contacts, container, false)
        return root
    }
}