package br.com.fiap.healfmind.viewModel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.fiap.healfmind.model.Meditacao

class MeditacoesViewModel {

    private val _tituloMeditacao = MutableLiveData<String>()

    val tituloMeditacao : LiveData<String> = _tituloMeditacao


    fun onTituloChanged(notoTitulo: String){
        _tituloMeditacao.value = notoTitulo
    }
}