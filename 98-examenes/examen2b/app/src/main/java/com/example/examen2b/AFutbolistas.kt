package com.example.examen2b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AFutbolistas : AppCompatActivity() {

    var itemSelected = 0

    override fun onCreate( savedInstanceState: Bundle? ) {

        super.onCreate( savedInstanceState )
        setContentView( R.layout.activity_afutbolista )

        val btnCrearFutbolista = findViewById<Button>(R.id.btn_ir_crear_futbolista)
        btnCrearFutbolista
            .setOnClickListener {
                openActivity( ACrearFutbolista::class.java )
            }

        val listView = findViewById<ListView>( R.id.lv_futbolistas )
        var arrFutbolistaNombre = arrayListOf<String>()

        val db = Firebase.firestore
        val futbolistasRef = db
            .collection("futbolistas")
            .orderBy("nombre")
        futbolistasRef
            .get()
            .addOnSuccessListener {
                for (futbolista in it){
                    arrFutbolistaNombre.add("${futbolista.get("nombre").toString()}")
                }
                val futAdapter = ArrayAdapter(
                    this,
                    android.R.layout.simple_list_item_1,
                    //BDDMemoria.arrOFutbolista
                    arrFutbolistaNombre
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
        inflater.inflate( R.menu.menu_futbolistas, menu )
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
    }

    override fun onContextItemSelected( item: MenuItem ): Boolean {
        return when( item.itemId ) {
            R.id.mf_editar -> {
                openActivityWithParameters( AEditarFutbolista::class.java )
                return true
            }
            R.id.mf_eliminar -> {
                delete( itemSelected )
                return true
            }
            R.id.mf_ver -> {
                openActivityWithParameters( BGoles::class.java )
                return true
            }
            else -> return super.onContextItemSelected( item )
        }
    }

    fun openActivityWithParameters(
        clase: Class<*>
    ){
        val intentFutbolista = Intent(this,clase)
        intentFutbolista.putExtra( "posicion", itemSelected + 1)
        startActivity( intentFutbolista )
    }

    fun delete(
        itemSelected: Int
    ){
        val listViewFutbolistas = findViewById<ListView>( R.id.lv_futbolistas )
        BDDMemoria.arrOFutbolista.removeAt( itemSelected )
        var arrFutbolistaNombre = arrayListOf<String>()
        BDDMemoria.arrOFutbolista.forEach { futbolista: OFutbolista ->
            arrFutbolistaNombre.add(futbolista.nombre.toString())
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrFutbolistaNombre
        )
        listViewFutbolistas.adapter = futAdapter
        futAdapter.notifyDataSetChanged()
    }

}