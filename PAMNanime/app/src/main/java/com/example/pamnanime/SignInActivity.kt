package com.example.pamnanime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.pamnanime.databinding.ActivitySignInBinding
import com.example.pamnanime.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignInActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignInBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)

        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.GoSignUpText.setOnClickListener{
            val intent = Intent(this, SignUpActivity:: class.java)
            startActivity(intent)
        }

        binding.SignInButton.setOnClickListener{
            val email = binding.UserEmail.text.toString()
            val pass = binding.UserPassword.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() ){
                if(android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

                    auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            //crear pagina donde se ven anime
                            val intent = Intent(this, HomeActivity::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                        Toast.makeText(this, "Error, email no compatible", Toast.LENGTH_SHORT).show()






                }


            }else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }


        }






        
    }
}