package com.example.proyectofinal_david_rodriguez_aranda.adapters

import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectofinal_david_rodriguez_aranda.databinding.SelectorMesaLayoutBinding
import com.example.proyectofinal_david_rodriguez_aranda.models.Camarero
import com.example.proyectofinal_david_rodriguez_aranda.models.Mesa

class MesasViewHolder(v: View): RecyclerView.ViewHolder(v) {
    val binding= SelectorMesaLayoutBinding.bind(v)

    fun render(m: Mesa, c: Camarero, onMensajePulsado: (Mesa) -> Unit) {
        if(m.estado==0) {
            binding.ivMesaLibre.isVisible= true
            binding.ivMesaPreparandose.isVisible= false
            binding.ivMesaOcupada.isVisible= false
            binding.tvEstadoMesa.text = "LIBRE"

        }else if(m.estado==1) {

            if(m.camarero?.email.equals(c.email)) {
                binding.ivMesaLibre.isVisible= false
                binding.ivMesaPreparandose.isVisible= true
                binding.ivMesaOcupada.isVisible= false
                binding.tvEstadoMesa.text = "ASIGNADA"
            }else {
                binding.ivMesaLibre.isVisible= false
                binding.ivMesaPreparandose.isVisible= false
                binding.ivMesaOcupada.isVisible= true
                binding.tvEstadoMesa.text = "OCUPADA"
            }
        }

        binding.tvNumMesa.text= "MESA ${m.numMesa}"
        binding.cvMesa.setOnClickListener {
            onMensajePulsado(m)
        }

    }
}
