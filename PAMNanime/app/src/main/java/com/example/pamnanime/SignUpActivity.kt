package com.example.pamnanime

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pamnanime.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast


class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var auth: FirebaseAuth;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)

        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.GoSignInText.setOnClickListener{
            val intent = Intent(this, SignInActivity:: class.java)
            startActivity(intent)
        }



        binding.SignUpButton.setOnClickListener{
            val email = binding.UserEmail.text.toString()
            val pass = binding.UserPassword1.text.toString()
            val confirmPass = binding.UserPassword2.text.toString()
            if (email.isNotEmpty() && pass.isNotEmpty() && confirmPass.isNotEmpty() && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                if(pass == confirmPass){
                    auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener{
                        if(it.isSuccessful){
                            val intent = Intent(this, SignUpActivity:: class.java)
                            startActivity(intent)

                        }else{
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }

                }else{
                    Toast.makeText(this, "Password is not matching", Toast.LENGTH_SHORT).show()
                }
            }else{
                Toast.makeText(this, "Empty fields are not allowed", Toast.LENGTH_SHORT).show()
            }


        }


        supportActionBar?.hide()
    }
}


