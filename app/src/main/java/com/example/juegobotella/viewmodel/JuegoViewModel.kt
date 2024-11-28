package com.example.juegobotella.viewmodel

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

class JuegoViewModel : ViewModel() {

    //Llamamos a la clase Rotacion para que rote la img
    private val _rotacionBotella = MutableLiveData<RotateAnimation>()
    val rotacionBotella: LiveData<RotateAnimation> get() = _rotacionBotella

    fun splashScreen(activity: Spash) {
        val handler = Handler()
        handler.postDelayed({
            activity.startActivity(Intent(activity, MainActivity::class.java))
            activity.finish()
        }, TIEMPO)
    }

    fun girarBotella() {
        val grados = (Math.random() * 3600) + 1080
        val rotacion = RotateAnimation(
            0f, grados.toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotacion.fillAfter = true
        rotacion.duration = 3600
        rotacion.interpolator = DecelerateInterpolator()

        rotacion.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationEnd(animation: Animation?) {
                TODO("Not yet implemented")
            }

            override fun onAnimationRepeat(animation: Animation?) {
                TODO("Not yet implemented")
            }

        })

        _rotacionBotella.value = rotacion
    }
}