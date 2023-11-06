

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginScreenViewModel : ViewModel() {

    private val _texto = MutableLiveData<String>()
    val texto: LiveData<String> = _texto

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password

    fun onTextoChanged(novoTexto: String){
        _texto.value = novoTexto
    }

    fun onPasswordChanged(novoPassword: String){
        _password.value = novoPassword
    }
}