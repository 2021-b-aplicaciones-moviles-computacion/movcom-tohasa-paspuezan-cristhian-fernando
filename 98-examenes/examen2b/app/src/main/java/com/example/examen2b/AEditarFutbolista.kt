package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class AEditarFutbolista : AppCompatActivity() {

    var idFutbolista = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aeditar_futbolista)
        idFutbolista = intent.getIntExtra("posicion",1)
        val txtActividad = findViewById<TextInputEditText>(R.id.txt_editar_actividad)
        val txtProGPP = findViewById<TextInputEditText>(R.id.txt_editar_promediogpp)
        val tvNombre = findViewById<TextView>(R.id.tv_editar_nombre)
        BDDMemoria.arrOFutbolista.forEachIndexed { index: Int, futbolista: OFutbolista ->
            if(index == idFutbolista){
                tvNombre.setText(futbolista.nombre.toString())
                txtActividad.setText(futbolista.actividad.toString())
                txtProGPP.setText(futbolista.proGPP.toString())
            }
        }
        val btnSave = findViewById<Button>(R.id.btn_save_futbolista)
        btnSave.setOnClickListener {
            BDDMemoria.arrOFutbolista.forEachIndexed { index: Int, futbolista: OFutbolista ->
                if(index == idFutbolista){
                    futbolista.actividad = txtActividad.text.toString().trim().toBoolean()
                    futbolista.proGPP = txtProGPP.text.toString().trim().toDouble()
                }
            }
            val intentFutbolista = Intent(this, AFutbolistas::class.java)
            startActivity(intentFutbolista)
        }
    }

}
