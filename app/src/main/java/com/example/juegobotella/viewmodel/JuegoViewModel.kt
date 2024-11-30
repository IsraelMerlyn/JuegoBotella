package com.example.juegobotella.viewmodel

import android.content.Context
import android.content.Intent
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.juegobotella.utils.Constantes.TIEMPO
import com.example.juegobotella.view.MainActivity
import com.example.juegobotella.view.Spash
import com.example.juegobotella.view.dialogo.DialogoMostrarReto.showDialogMostrarReto

class JuegoViewModel : ViewModel() {

    //Llamamos a la clase Rotacion para que rote la img
    private val _rotacionBotella = MutableLiveData<RotateAnimation>()
    val rotacionBotella: LiveData<RotateAnimation> get() = _rotacionBotella

    //variable que se encarga de observar el giro
    private val _habilitarBoton = MutableLiveData(true)
    val hailitarBoton: LiveData<Boolean> get() = _habilitarBoton

    //habilitar animacion serpentina
    private val _isCerpentina = MutableLiveData(false)
    val isCerpentina: LiveData<Boolean> get() = _isCerpentina

    //Estado de movimiento de la botella
    private val _estadoRotacionBotella = MutableLiveData(false)
    val estadoRotacionBotella: LiveData<Boolean> get() = _estadoRotacionBotella


    //Estatus del Dialogo
    private  val  _statusShowDialog = MutableLiveData(false)
    val  statusShowDialog:LiveData<Boolean> get() = _statusShowDialog


    fun splashScreen(activity: Spash) {
        val handler = Handler()
        handler.postDelayed({
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }, TIEMPO)
    }

    fun girarBotella() {

        _habilitarBoton.value = false
        _isCerpentina.value = true
        _estadoRotacionBotella.value = true

        val grados = (Math.random() * 3600) + 1080
        val rotacion = RotateAnimation(
            0f, grados.toFloat(), Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotacion.fillAfter = true
        rotacion.duration = 3600
        rotacion.interpolator = DecelerateInterpolator()

        rotacion.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                _isCerpentina.value = false
                _habilitarBoton.value = true
                _estadoRotacionBotella.value = false
                _statusShowDialog.value = true
            }

            override fun onAnimationRepeat(animation: Animation?) {

            }

        })

        _rotacionBotella.value = rotacion
    }

    fun dialogoMostrarReto(context: Context, mensajeReto: String) {
        showDialogMostrarReto(context, mensajeReto)
    }

    fun statusShowDialogo(status: Boolean) {
        _statusShowDialog.value = status
    }
}