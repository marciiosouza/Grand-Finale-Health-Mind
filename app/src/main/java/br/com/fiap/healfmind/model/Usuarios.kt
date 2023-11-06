package br.com.fiap.healfmind.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Tb_Usuarios")
data class Usuarios(
    @PrimaryKey(autoGenerate = true)
    var id : Long = 0,
    var nome : String = "",
    var email : String = "",
    var senha : String = ""
)
