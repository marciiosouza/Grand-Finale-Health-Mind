package br.com.fiap.healfmind.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class MarcarConsultaScreenViewModel {

    private val _tipoConsulta = MutableLiveData<String>()
    val tipoConsulta : LiveData<String> = _tipoConsulta

    fun onTipoConsultaChanged(novoValor : String){
        _tipoConsulta.value = novoValor
    }
}