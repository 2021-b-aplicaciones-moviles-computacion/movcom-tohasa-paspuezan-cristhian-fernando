package com.example.myapplication

import android.content.DialogInterface
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
import androidx.appcompat.app.AlertDialog

class BListView : AppCompatActivity() {

    var iditemSeleccionado = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blist_view)

        val listView = findViewById<ListView>( R.id.lv_list_view )
        val arreglo: ArrayList<Int> = arrayListOf( 1, 2, 3, 4, 5 )
        val adaptador = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            arreglo
        )

        listView.adapter = adaptador
        adaptador.notifyDataSetChanged()

        val botonAnadirItem = findViewById<Button>( R.id.btn_anadir_list_view )
        botonAnadirItem
            .setOnClickListener {
                anadirItem( adaptador, arreglo, 1 )
            }

//        listView
//            .setOnItemLongClickListener { parent, view, position, id ->
//                Log.i("list-view", "LONG CLICK ${arreglo[position]}")
//                return@setOnItemLongClickListener true
//            }

        // 1) Registrar menu contextual
        // this.registerForContextMenu( listView )
        registerForContextMenu( listView )

    }

    // 2) Seleccionar el XML a usar en el menu contextual

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var inflater = menuInflater
        inflater.inflate( R.menu.menu, menu )
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        iditemSeleccionado = id
        Log.i( "context-menu", "Posicion: ${id}" )
    }

    // 3) Que opcion selecciono

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when( item.itemId ) {
            R.id.mi_editar -> {
                Log.i( "context-menu", "Editar Posicion: ${iditemSeleccionado}" )
                abrirDialogo()
                return true
            }
            R.id.mi_eliminar -> {
                Log.i( "context-menu", "Eliminar Posicion: ${iditemSeleccionado}" )
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }

    fun abrirDialogo() {

        val builder = AlertDialog.Builder( this )

        builder.setTitle( "Titulo" )

//        builder.setMessage( "Descripcion" ) // El mensaje no deja visualizar los multiples choice tener CUIDADO!

        val opciones = resources.getStringArray(
            R.array.string_array_opciones_dialogo
        )

        val seleccionPrevia = booleanArrayOf(
            true,
            false,
            false
        )

        builder.setMultiChoiceItems(
            opciones,
            seleccionPrevia,
            {
                dialog,
                which,
                isChecked ->
                    Log.i( "dialog", "Dio clic en el item ${which}" )
            }
        )

        builder.setPositiveButton(
            "Aceptar",
            DialogInterface.OnClickListener { dialog, wich ->
                Log.i( "dialog", "Hola =)" )
            }
        )

        builder.setNegativeButton(
            "Cancelar",
            null
        )

        val dialogo = builder.create()
        dialogo.show()

    }

    fun anadirItem(
        adaptador: ArrayAdapter<Int>,
        arreglo: ArrayList<Int>,
        valor: Int
    ) {
        arreglo.add( valor )
        adaptador.notifyDataSetChanged()
    }

}