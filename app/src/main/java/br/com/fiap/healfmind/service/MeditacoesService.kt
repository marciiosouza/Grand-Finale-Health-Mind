package br.com.fiap.healfmind.service

import br.com.fiap.healfmind.model.Meditacao
import br.com.fiap.healfmind.model.MeditacaoDestaque
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface MeditacoesService {

    @GET("/meditacoes/ObterTodos/")
    fun getMeditacoes(): Call<List<Meditacao>>

    @GET("/meditacoes/{id}")
    fun pesquisarPorId(@Path("id") id: Int): Call<Meditacao>


    @POST("/meditacaoDestaque/")
    fun RegistrarAcesso( @Body meditacaoDestaque: MeditacaoDestaque) : Call<MeditacaoDestaque>


    @GET("/meditacaoDestaque/")
    fun MeditacaoDestaque() :Call<Meditacao>
}