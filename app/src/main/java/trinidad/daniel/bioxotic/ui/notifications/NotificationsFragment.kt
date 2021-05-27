package trinidad.daniel.bioxotic.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.calculate_size_fragment.*
import trinidad.daniel.bioxotic.Profile
import trinidad.daniel.bioxotic.R

class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    private lateinit var et_length: EditText
    private lateinit var et_width: EditText
    private lateinit var et_height: EditText

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
                ViewModelProvider(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.calculate_size_fragment, container, false)
        /*val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        et_length= root.findViewById(R.id.et_length)
        et_width= root.findViewById(R.id.et_width)
        et_height= root.findViewById(R.id.et_height)

        val button_user_profile: ImageButton = root.findViewById(R.id.ib_user_profile)
        button_user_profile.setOnClickListener {
            var userProfileIntent: Intent? = Intent(root.context, Profile::class.java)
            startActivity(userProfileIntent)
        }

        val btn_calcular: Button =  root.findViewById(R.id.btn_calculate)

        btn_calcular.setOnClickListener {
            calcular()
        }

        return root
    }

    fun calcular (){
        var length = et_length.text.toString().toFloat()
        var width = et_width.text.toString().toFloat()
        var heigth = et_height.text.toString().toFloat()

        tv_length.setText((length*2).toString()+" cm")
        tv_height.setText((heigth*2).toString()+" cm")
        tv_width.setText((width*2).toString()+" cm")

        //limpiar
        et_length.setText("")
        et_width.setText("")
        et_height.setText("")

    }
}