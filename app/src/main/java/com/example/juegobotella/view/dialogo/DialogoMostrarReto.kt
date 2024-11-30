package com.example.juegobotella.view.dialogo

import android.content.Context
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import com.example.juegobotella.databinding.DialogoMostrarRetoBinding

object DialogoMostrarReto {
    fun showDialogMostrarReto(context: Context, mensajeReto: String){
        //asociamos el xml de la ventana ded dialogo
        val inflater = LayoutInflater.from(context)
        val binding = DialogoMostrarRetoBinding.inflate(inflater)

        val alertDialog = AlertDialog.Builder(context).create()
        alertDialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        alertDialog.setCancelable(false)
        alertDialog.setView(binding.root)

        //accion del texto en el dialogo
        binding.tvReto.text = mensajeReto


        //accion del boton cerrar
        binding.btnCerrar.setOnClickListener { alertDialog.dismiss() }

        alertDialog.show()
    }
}