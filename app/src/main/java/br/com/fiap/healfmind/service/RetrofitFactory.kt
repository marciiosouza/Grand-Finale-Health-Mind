package br.com.fiap.healfmind.service
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val URL = "https://192.168.0.100:7076/"

    private val retrofitFactory = Retrofit.Builder().baseUrl(URL).addConverterFactory(
        GsonConverterFactory.create()).build()


    fun getUsuarioService():UsuarioService{
        return retrofitFactory.create(UsuarioService::class.java)
    }
}