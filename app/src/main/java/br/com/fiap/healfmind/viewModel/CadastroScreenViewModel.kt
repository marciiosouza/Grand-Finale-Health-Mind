package br.com.fiap.healfmind.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CadastroScreenViewModel : ViewModel() {

    private val _nome = MutableLiveData<String>()
    val nome : LiveData<String> = _nome
    fun onNameChanged(novoValor : String){
        _nome.value = novoValor
    }

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email
    fun onEmailChanged(novoValor : String){
        _email.value = novoValor
    }

    private val _senha = MutableLiveData<String>()
    val senha : LiveData<String> = _senha
    fun onSenhaChanged(novoValor : String){
        _senha.value = novoValor
    }

}