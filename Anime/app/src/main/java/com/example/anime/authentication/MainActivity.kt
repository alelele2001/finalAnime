package com.example.anime.authentication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.anime.R
import com.google.firebase.FirebaseApp
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bd = FirebaseFirestore.getInstance()

        bd.collection("user").add("Prueba")

    }
}