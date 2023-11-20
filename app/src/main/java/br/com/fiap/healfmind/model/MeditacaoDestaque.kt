package br.com.fiap.healfmind.model

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

data class MeditacaoDestaque(
    val MeditacaoId: Int,
    val UsuarioId: Long,
    val DataAcesso: LocalDateTime
)
