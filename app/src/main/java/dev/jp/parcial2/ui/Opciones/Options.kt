package dev.jp.parcial2.ui.Opciones

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dev.jp.parcial2.LogInActivity
import dev.jp.parcial2.R
import dev.jp.parcial2.databinding.FragmentGeneracionesBinding
import dev.jp.parcial2.databinding.FragmentOptionsBinding

class Options : Fragment() {

    private var _binding: FragmentOptionsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //val dashboardViewModel =
        //    ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentOptionsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        val imc = findNavController()

        binding.btnIMC.setOnClickListener {
            imc.navigate(R.id.navigation_imc)
        }
        binding.btnSigno.setOnClickListener { imc.navigate(R.id.navigation_signozodiacal) }
        binding.btnGEN.setOnClickListener {  imc.navigate(R.id.navigation_generaciones)}
        binding.btnRegresar.setOnClickListener {
            val intent = Intent(requireContext(),LogInActivity::class.java)
            startActivity(intent)
        }
        //val textView: TextView = binding.textDashboard
        //dashboardViewModel.text.observe(viewLifecycleOwner) {
        //    textView.text = it
        //}
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}