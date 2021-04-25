package aviles.itzel.bioxotic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class PincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pincipal)

        val bundle = intent.extras
        if( bundle != null ){
            val name = bundle.getString("name")
            val email = bundle.getString("email")

            val tv_name:  TextView= findViewById(R.id.tv_name)
            val tv_email:  TextView= findViewById(R.id.tv_email)

            tv_name.setText(name)
            tv_email.setText(email)

        }

        val btn_close:  TextView= findViewById(R.id.btn_close)
        btn_close.setOnClickListener{
            finish()
        }
        
    }
}