package com.example.juegobotella.viewmodel

import android.content.Intent
import android.os.Handler
import androidx.lifecycle.ViewModel
import com.example.juegobotella.utils.Constantes.TIEMPO
import com.example.juegobotella.view.MainActivity
import com.example.juegobotella.view.Spash

class JuegoViewModel:ViewModel() {

    fun splashScreen(activity: Spash){
        val handler= Handler()
        handler.postDelayed({
           activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        },TIEMPO)
    }
}