package com.example.proyecto2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.firebase.ui.auth.AuthUI

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin = findViewById<Button>(R.id.btn_ir_login)
        btnLogin
            .setOnClickListener {
                login()
            }

        val btnLogout = findViewById<Button>(R.id.btn_ir_logout)
        btnLogout
            .setOnClickListener {
                logout()
            }

    }

    fun openActivity(
        clase: Class<*>,
    ) {
        val intent = Intent( this,clase )
        startActivity( intent )
    }

    fun login(){
        val providers = arrayListOf(
            AuthUI.IdpConfig.EmailBuilder().build()
        )
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setAvailableProviders(providers)
                .setTosAndPrivacyPolicyUrls(
                    "https://example.com/terms.html",
                    "https://example.com/privacy.html"
                )
                .build(),
            200
        )
    }

    fun logout(){
        AuthUI
            .getInstance()
            .signOut(this)
            .addOnCompleteListener {

            }
    }

}