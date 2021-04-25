package aviles.itzel.bioxotic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class hospital_contacts : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hospital_contacts)

        val bundle = intent.extras
        if(bundle != null ){
            val nombre = bundle.getString("name")
            val correo = bundle.getString("nemail")


        }
    }
}