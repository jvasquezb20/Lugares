package com.lugare_v.ui.lugar

import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
//import android.Manifest
import android.os.FileObserver.ACCESS
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.lugare_v.Manifest
import com.lugare_v.R
import com.lugare_v.databinding.FragmentAddLugarBinding
import com.lugare_v.model.Lugar
import com.lugare_v.viewmodel.LugarViewModel

class AddLugarFragment : Fragment() {
    private var _binding: FragmentAddLugarBinding? = null
    private val binding get() = _binding!!
    private lateinit var lugarViewModel: LugarViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        lugarViewModel = ViewModelProvider(this).get(LugarViewModel::class.java)

        _binding = FragmentAddLugarBinding.inflate(inflater, container, false)

        binding.btAddLugar.setOnClickListener{addLugar()}
        return binding.root
    }

    private fun activeGPS(){
        if(requireActivity().
            checkSelfPermission(android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED &&
                requireActivity().
                checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED){

            requireActivity().requestPermissions(arrayOf(
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION),105)
        }else{
        val fusedLocationClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(requireContext())
            fusedLocationClient.lastLocation.addOnSuccessListener {
                    location: Location? ->
                if(location!=null){
                    binding.tvLatitud.text = "${location.latitude}"
                    binding.tvLongitud.text = "${location.longitude}"
                    binding.tvAltura.text = "${location.altitude}"

                }else{
                    binding.tvLatitud.text = "0.0"
                    binding.tvLongitud.text = "0.0"
                    binding.tvAltura.text = "0.0"
                }

            }
        }
    }



    private fun addLugar() {
        val nombre = binding.etNombre.text.toString()
        val correo = binding.etCorreoLugar.text.toString()
        val telefono = binding.etTelefono.text.toString()
        val web = binding.etWeb.text.toString()
        val latitud= binding.tvLatitud.text.toString().toDouble()
        val longitud= binding.tvLongitud.text.toString().toDouble()
        val altura= binding.tvAltura.text.toString().toDouble()

        if (nombre.isNotEmpty()){ //al menos tenemos un nombre
            val lugar= Lugar(0,nombre,correo,telefono,web,
                latitud,longitud,altura, " "," ")

            lugarViewModel.saveLugar(lugar)
            Toast.makeText(requireContext(),getText(R.string.msg_lugar_added),
            Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addLugarFragment_to_nav_lugar)
        }else {
            Toast.makeText(requireContext(),getText(R.string.msg_datos),
            Toast.LENGTH_LONG).show()

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}