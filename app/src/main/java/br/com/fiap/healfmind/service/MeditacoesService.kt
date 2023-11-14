package br.com.fiap.healfmind.service

import br.com.fiap.healfmind.model.Meditacao
import retrofit2.Call
import retrofit2.http.GET

interface MeditacoesService {

    @GET("/meditacoes/ObterTodos/")
    fun getMeditacoes(): Call<List<Meditacao>>
}