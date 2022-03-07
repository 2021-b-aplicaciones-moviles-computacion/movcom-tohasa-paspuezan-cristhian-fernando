package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class BEditarGol : AppCompatActivity() {

    var idGol = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_beditar_gol)
        idGol = intent.getIntExtra("posicion",1)
        val txtPenal = findViewById<TextInputEditText>(R.id.txt_editar_penal)
        val txtMinuto = findViewById<TextInputEditText>(R.id.txt_editar_minuto)
        val tvTipo = findViewById<TextView>(R.id.tv_editar_tipo)
        BDDMemoria.arrOGol.forEachIndexed { index: Int, gol: OGol ->
            if(index == idGol){
                tvTipo.setText(gol.tipo.toString())
                txtPenal.setText(gol.penal.toString())
                txtMinuto.setText(gol.minuto.toString())
            }
        }
        val btnSave = findViewById<Button>(R.id.btn_save_gol)
        btnSave.setOnClickListener {
            BDDMemoria.arrOGol.forEachIndexed { index: Int, gol: OGol ->
                if(index == idGol){
                    gol.penal = txtPenal.text.toString().trim().toBoolean()
                    gol.minuto = txtMinuto.text.toString().trim().toDouble()
                }
            }
            val intentGol = Intent(this, BGoles::class.java)
            startActivity(intentGol)
        }
    }
}