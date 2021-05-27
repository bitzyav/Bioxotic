package trinidad.daniel.bioxotic

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignIn : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.hide()

        auth = Firebase.auth

        val btn_sign_in : Button = findViewById(R.id.btn_sign_in)
        btn_sign_in.setOnClickListener{
            //var signInIntent: Intent? = Intent(this, Menu_species::class.java)
            /*var signInIntent: Intent? = Intent(this, MainActivity::class.java)
            startActivity(signInIntent)
            */
            validate_login()
        }

        val forgotPassword:TextView= findViewById(R.id.text_forgot_password)
        forgotPassword.setOnClickListener {
            var signInIntent: Intent? = Intent(this, Request_email::class.java)
            startActivity(signInIntent)
        }

        val createOne:TextView= findViewById(R.id.text_create_one)
        createOne.setOnClickListener {
            var signInIntent: Intent? = Intent(this, SignUp::class.java)
            startActivity(signInIntent)
        }

    }

    private fun validate_login(){

        var email: String = et_email.text.toString()
        var password: String = et_password.text.toString()

        if(!email.isNullOrBlank() && !password.isNullOrBlank()){
            firebase_login(email, password)
        }else{
            Toast.makeText(this, "Complete the form",
                Toast.LENGTH_SHORT).show()
        }

    }

    private fun firebase_login(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    //Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    val intent: Intent = Intent(this, MainActivity::class.java)
                    startActivityForResult(intent, 123)
                    //updateUI(user)
                } else {
                    // If sign in fails, display a message to the user.
                    //Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()
                    //updateUI(null)
                }
            }
    }


}