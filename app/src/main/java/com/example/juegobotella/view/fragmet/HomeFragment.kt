package com.example.juegobotella.view.fragmet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.juegobotella.R
import com.example.juegobotella.databinding.FragmentHomeBinding
import com.example.juegobotella.viewmodel.JuegoViewModel

class HomeFragment : Fragment() {

    //    private  lateinit var  navController: NavController
    private val juegoViewModel: JuegoViewModel by viewModels()
    private lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        controladores(view)
        observadorViewModel()

    }

    private fun controladores(view: View) {
        //navegacion hacia otra vista
        //  navController = Navigation.findNavController(view)
        binding.icContentMenu.idImgReglas.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_reglasJuegoFragment)
        }

        binding.btnGirar.setOnClickListener {
            juegoViewModel.girarBotella()
        }
    }

    private fun observadorViewModel() {
        observadorRotacionBotella()
        observadorHabilitarBoton()
        observadorCerpentinaOn()

    }

    private fun observadorCerpentinaOn() {
        juegoViewModel.isCerpentina.observe(viewLifecycleOwner) { status ->
            binding.lottieCerpentina.isVisible = status
            binding.lottieCerpentina.playAnimation()
        }
    }

    private fun observadorHabilitarBoton() {
        juegoViewModel.hailitarBoton.observe(viewLifecycleOwner) { habilitarBoton ->
            binding.btnGirar.isVisible = habilitarBoton
        }
    }

    private fun observadorRotacionBotella() {
        juegoViewModel.rotacionBotella.observe(viewLifecycleOwner) { rotacion ->
            juegoViewModel.estadoRotacionBotella.observe(viewLifecycleOwner) { estadoRotacion ->
                if (estadoRotacion) binding.ivBotella.startAnimation(rotacion)

            }

        }
    }
}