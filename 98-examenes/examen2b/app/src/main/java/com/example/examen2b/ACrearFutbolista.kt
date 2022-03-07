package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ACrearFutbolista : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_acrear_futbolista)

        val botonCrearFutbolista = findViewById<Button>(R.id.btn_crear_futbolista)
        botonCrearFutbolista
            .setOnClickListener {
                crearFutbolista()
                openActivity( AFutbolistas::class.java )
            }

    }

    fun openActivity(
        clase: Class<*>,
    ) {
        val intent = Intent( this,clase )
        startActivity( intent )
    }

    fun crearFutbolista() {
        val editTextNombre = findViewById<EditText>(R.id.et_nombre_futbolista)
        val editTextAtividad = findViewById<EditText>(R.id.et_actividad_futbolista)
        val editTextPromedioGPP = findViewById<EditText>(R.id.et_promediogpp_futbolista)
        val nuevoFutbolista = hashMapOf<String, Any>(
            "nombre" to editTextNombre.text.toString(),
            "actividad" to editTextAtividad.text.toString().toBoolean(),
            "promedioGPP" to editTextPromedioGPP.text.toString().toDouble()
        )
        val db = Firebase.firestore
        val referencia = db.collection("futbolistas")
        referencia
            .add(nuevoFutbolista)
            .addOnSuccessListener {
                editTextNombre.text.clear()
                editTextAtividad.text.clear()
                editTextPromedioGPP.text.clear()
            }
            .addOnFailureListener { }
    }

}