package br.com.fiap.healfmind.service

import br.com.fiap.healfmind.model.Meditacao
import br.com.fiap.healfmind.model.Usuarios
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UsuarioService {


    @GET("{email}/{senha}")
    fun getUsuarioByEmailSenha(
        @Path("email") email: String,
        @Path("senha") senha: String
    ): Call<Usuarios>

    @GET
    fun getMeditacoes(): Call<List<Meditacao>>

    @FormUrlEncoded
    @POST("/cadastrar")
    fun inserirUsuario(
        @Field("nome") nome: String,
        @Field("email") email: String,
        @Field("senha") senha: String
    ): Call<Usuarios>
}