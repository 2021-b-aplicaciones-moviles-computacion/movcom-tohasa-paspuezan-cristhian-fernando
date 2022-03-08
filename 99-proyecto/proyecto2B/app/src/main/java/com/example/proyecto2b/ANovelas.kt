package com.example.proyecto2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ANovelas : AppCompatActivity() {

    var itemSelected = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_anovelas)

        val btnCrearLibro = findViewById<Button>(R.id.btn_ir_crear_novela)
        btnCrearLibro
            .setOnClickListener {
                openActivity( ACrearNovela::class.java )
            }

        val listView = findViewById<ListView>( R.id.lv_novelas )
        var arrNovelasNombre = arrayListOf<String>()

        val db = Firebase.firestore
        val novelasRef = db
            .collection("novelas")
            .orderBy("titulo")
        novelasRef
            .get()
            .addOnSuccessListener {
                for (novela in it){
                    arrNovelasNombre.add("${novela.get("titulo").toString()}")
                }
                val futAdapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    arrNovelasNombre
                )
                listView.adapter = futAdapter
                futAdapter.notifyDataSetChanged()
                registerForContextMenu( listView )
            }
            .addOnFailureListener {  }

    }

    fun openActivity(
        clase: Class<*>,
    ) {
        val intent = Intent( this,clase )
        startActivity( intent )
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu( menu, v, menuInfo )
        var inflater = menuInflater
        inflater.inflate( R.menu.menu_novelas, menu )
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
    }

    override fun onContextItemSelected( item: MenuItem): Boolean {
        return when( item.itemId ) {
            R.id.mf_editar -> {
                openActivityWithParameters( AEditarNovela::class.java )
                return true
            }
            R.id.mf_eliminar -> {
                return true
            }
            R.id.mf_ver -> {
                return true
            }
            else -> return super.onContextItemSelected( item )
        }
    }

    fun openActivityWithParameters(
        clase: Class<*>
    ){
        val intentNovela = Intent(this,clase)
        intentNovela.putExtra( "posicion", itemSelected + 1)
        startActivity( intentNovela )
    }

}