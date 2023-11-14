package br.com.fiap.healfmind.service

import br.com.fiap.healfmind.model.Meditacao
import br.com.fiap.healfmind.model.Usuarios
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioService {


    @POST("/login")
    fun getUsuarioByEmailSenha(
        @Body usuario : Usuarios
    ): Call<Usuarios>




    @POST("cadastrar")
    fun inserirUsuario( @Body usuario : Usuarios ): Call<Usuarios>


}