package br.com.fiap.healfmind.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PerfilScreenViewModel : ViewModel() {

    private val _nome = MutableLiveData<String>()
    val nome : LiveData<String> = _nome

    private val _cpf = MutableLiveData<String>()
    val cpf : LiveData<String> = _cpf

    private val _celular = MutableLiveData<String>()
    val celular : LiveData<String> = _celular

    private val _email = MutableLiveData<String>()
    val email : LiveData<String> = _email

    private val _endereco = MutableLiveData<String>()
    val endereco : LiveData<String> = _endereco


    fun onNomeChanged(novoNome : String){
        _nome.value = novoNome
    }

    fun onCpfChanged(novoCpf : String){
        _cpf.value = novoCpf
    }
    fun onCelularChanged(novoCelular : String){
        _celular.value = novoCelular
    }
    fun onEmailChanged(novoEmail : String){
        _email.value = novoEmail
    }
    fun onEnderecoChanged(novoEndereco : String){
        _endereco.value = novoEndereco
    }


}