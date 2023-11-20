package br.com.fiap.healfmind.service

import br.com.fiap.healfmind.model.Meditacao
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface MeditacoesService {

    @GET("/meditacoes/ObterTodos/")
    fun getMeditacoes(): Call<List<Meditacao>>

    @GET("/meditacoes/{id}")
    fun pesquisarPorId(@Path("id") id: Int): Call<Meditacao>
}