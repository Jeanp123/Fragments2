package dev.jp.parcial2.ui.Opciones

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dev.jp.parcial2.LogInActivity
import dev.jp.parcial2.databinding.FragmentSignozodiacalBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class Signozodiacal : Fragment() {

    private var _binding: FragmentSignozodiacalBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val notificationsViewModel =
        //    ViewModelProvider(this).get(NotificationsViewModel::class.java)

        _binding = FragmentSignozodiacalBinding.inflate(inflater, container, false)
        val root: View = binding.root
        binding.btnConsult.setOnClickListener {
            val spf = SimpleDateFormat("dd/mm/yyyy", Locale.getDefault())
            val edad = CalcularEdad(spf.parse(binding.txtDate.text.toString()))
            val signo = CalcularSigno(spf.parse(binding.txtDate.text.toString()))
            binding.tvEdad.text = edad.toString()
            binding.tvSigno.text = signo
        }

        binding.btnRegSZ.setOnClickListener {
            val intent = Intent(requireContext(), LogInActivity::class.java)
            startActivity(intent)
        }
        //  val textView: TextView = binding.textNotifications
        //  notificationsViewModel.text.observe(viewLifecycleOwner) {
        //   textView.text = it
        //  }
        return root
    }

    private fun CalcularEdad(birthDate: Date):Int {
        val hoy = Calendar.getInstance()
        val mes = Calendar.getInstance()
        mes.time = birthDate

        var age = hoy.get(Calendar.YEAR) - mes.get(Calendar.YEAR)
        if (hoy.get(Calendar.DAY_OF_YEAR) < mes.get(Calendar.DAY_OF_YEAR))){
            age--
        }
        return age
    }

    private fun CalcularSigno(birthDate: Date): String{
        val calendar = Calendar.getInstance()
        calendar.time=birthDate
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        val month = calendar.get(Calendar.MONTH)+1

        return when (month){
            1 -> if (day < 20) "Capricornio" else "Acuario"
            2 -> if (day < 19) "Acuario" else "Picis"
            3 -> if (day < 19) "Picis" else "Aries"
            4 -> if (day < 21) "Picis" else "Aries"
            5 -> if (day < 20) "Picis" else "Aries"
            6 -> if (day < 21) "Picis" else "Aries"
            7 -> if (day < 21) "Picis" else "Aries"
            8 -> if (day < 23) "Picis" else "Aries"
            9 -> if (day < 23) "Picis" else "Aries"
            10 -> if (day < 23) "Picis" else "Aries"
            11 -> if (day < 22) "Picis" else "Aries"
            12 -> if (day < 22) "Picis" else "Aries"
            else -> "Fue"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}