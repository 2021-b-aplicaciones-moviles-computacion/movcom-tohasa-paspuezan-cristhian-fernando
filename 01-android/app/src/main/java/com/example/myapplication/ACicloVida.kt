package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class ACicloVida : AppCompatActivity() {

    var total = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aciclo_vida)
        Log.i("ciclo-vida", "onCreate")
        val botonCicloVida = findViewById<Button>(R.id.btn_ciclo_vida)
        botonCicloVida.setOnClickListener {
            aumentarTotal()
        }
    }
    fun aumentarTotal(){
        total = total + 1
        val textViewCicloVida = findViewById<TextView>(R.id.tv_ciclo_vida)
        textViewCicloVida.text = total.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.run {
            // GUARDAR LAS VARIABLES
            // PRIMITIVOS
            putInt("totalGuardado", total)
        }
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        val totalRecuperado:Int? = savedInstanceState.getInt("totalGuardado")
        if(totalRecuperado!= null){
            this.total = totalRecuperado
            val txvCicloVida = findViewById<TextView>(R.id.tv_ciclo_vida)
            txvCicloVida.text = total.toString()
        }
    }






    override fun onStart() {
        super.onStart()
        Log.i("ciclo-vida", "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i("ciclo-vida", "onResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("ciclo-vida", "onRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("ciclo-vida", "onPauseonPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("ciclo-vida", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("ciclo-vida", "onDestroy")
    }
}