package dev.jp.parcial2.ui.Opciones

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dev.jp.parcial2.databinding.FragmentImcBinding

class IMC : Fragment() {

    private var _binding: FragmentImcBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val homeViewModel =
        //    ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentImcBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnCalc.setOnClickListener {
            val peso = CalcularIMC(binding.txtPeso.text.toString().toDouble(),binding.txtEstat.text.toString().toDouble())
            val estatura = CalcularCAT(peso)
            binding.tvRes.text = peso.toString()
            binding.tvCat.text = estatura
        }
        //val textView: TextView = binding.textHome
        //homeViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}
        return root
    }
    private fun CalcularIMC (peso: Double,estatura: Double): Double{
        return peso / (estatura * estatura)
    }

    private fun CalcularCAT (peso: Double):String {
        return when{
            peso < 18.5 -> "Bajo Peso"
            peso in 18.5..24.9 -> "Peso Saludable"
            peso in 18.5..24.9 -> "Sobrepeso"
            else -> "Obesidad"
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}