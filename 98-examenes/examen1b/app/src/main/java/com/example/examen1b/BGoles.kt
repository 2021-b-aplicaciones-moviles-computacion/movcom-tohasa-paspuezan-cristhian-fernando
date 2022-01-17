package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

class BGoles : AppCompatActivity() {

    var itemSelected = 0
    var idFutbolista = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        idFutbolista = intent.getIntExtra("posicion",1)
        setContentView(R.layout.activity_bgoles)
        val listView = findViewById<ListView>( R.id.lv_goles )
        var arrGolTipo = arrayListOf<String>()
        BDDMemoria.arrOGol.forEach { goles: OGol ->
            if ( goles.id == idFutbolista )
                arrGolTipo.add(goles.tipo.toString())
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            //BDDMemoria.arrOFutbolista
            arrGolTipo
        )
        listView.adapter = futAdapter
        futAdapter.notifyDataSetChanged()
        registerForContextMenu( listView )
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu( menu, v, menuInfo )
        var inflater = menuInflater
        inflater.inflate( R.menu.menu_goles, menu )
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        itemSelected = id
    }

    override fun onContextItemSelected( item: MenuItem): Boolean {
        return when( item.itemId ) {
            R.id.mg_editar -> {
                openActivityWithParameters( BEditarGol::class.java )
                return true
            }
            R.id.mg_eliminar -> {
                delete( itemSelected )
                return true
            }
            else -> return super.onContextItemSelected( item )
        }
    }

    fun openActivityWithParameters(
        clase: Class<*>
    ){
        val intentGol = Intent(this,clase)
        intentGol.putExtra( "posicion", itemSelected )
        startActivity( intentGol )
    }

    fun delete(
        itemSelected: Int
    ){
        val listViewGoles = findViewById<ListView>( R.id.lv_goles )
        BDDMemoria.arrOGol.removeAt( itemSelected )
        var arrGolTipo = arrayListOf<String>()
        BDDMemoria.arrOGol.forEach { goles: OGol ->
            if ( goles.id == idFutbolista )
                arrGolTipo.add(goles.tipo.toString())
        }
        val futAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arrGolTipo
        )
        listViewGoles.adapter = futAdapter
        futAdapter.notifyDataSetChanged()
    }

}