package br.com.fiap.healfmind.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.fiap.healfmind.model.Usuarios

@Dao
interface UsuarioDao {

    @Insert
    fun salvar(usuario: Usuarios) : Long

    @Update
    fun atualizar(usuario: Usuarios) : Int

    @Query("SELECT * FROM tb_usuarios WHERE Id = :id")
    fun buscarUsuarioPeloId(id : Long) : Usuarios
    //@Query("SELECT * FROM tb_usuarios WHERE email = :email ") // : email é var
   // fun buscarUsuarioPeloEmail(email : String) : Usuarios
}