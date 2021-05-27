package trinidad.daniel.bioxotic

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_sign_up)
        auth = Firebase.auth

        val btn_sign_up: Button = findViewById(R.id.btn_sign_up)
        btn_sign_up.setOnClickListener {
            valida_registro()
        }

    }

    private fun valida_registro() {

        var correo: String = et_email.text.toString()
        var contra1: String = et_password.text.toString()
        var contra2: String = et_confirm_password.text.toString()

        if (!correo.isNullOrBlank() && !contra1.isNullOrBlank() &&
            !contra2.isNullOrBlank()
        ) {

            if (contra1 == contra2) {

                registrarFirebase(correo, contra1)

            } else {
                Toast.makeText(
                    this, "Las contraseña no coinciden",
                    Toast.LENGTH_SHORT
                ).show()
            }

        } else {
            Toast.makeText(
                this, "Ingresar datos",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun registrarFirebase(email: String, password: String) {

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "createUserWithEmail:success")
                    val user = auth.currentUser

                    Toast.makeText(
                        baseContext, "${user.email} se ha creado correctamente",
                        Toast.LENGTH_SHORT
                    ).show()
                    var signInIntent: Intent? = Intent(this, SignIn::class.java)
                    startActivity(signInIntent)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(
                        baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                    //updateUI(null)
                }
            }
    }
}