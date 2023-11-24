package br.com.fiap.healfmind.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitFactory {

    private val URL = "http://10.0.2.2:5212/"
    //private val URL = "191.233.203.36"

    private val retrofitFactory = Retrofit.Builder().baseUrl(URL).addConverterFactory(
        GsonConverterFactory.create()).build()


    fun getUsuarioService():UsuarioService{
        return retrofitFactory.create(UsuarioService::class.java)
    }

    fun getMeditacoesService():MeditacoesService{
        return  retrofitFactory.create(MeditacoesService::class.java)
    }
}