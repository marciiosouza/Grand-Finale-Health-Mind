package br.com.fiap.healfmind.database.repository

import android.content.Context
import br.com.fiap.healfmind.database.dao.UsuarioDb
import br.com.fiap.healfmind.model.Usuarios

class UsuarioRepository(context: Context) {

    var db = UsuarioDb.getDatabase(context).usuarioDao()

    fun salvar(usuarios: Usuarios): Long{
        return db.salvar(usuario = usuarios)
    }

    fun atualiza(usuarios: Usuarios): Int{
        return db.atualizar(usuario = usuarios)
    }

    fun buscarPorId(id : Long) : Usuarios{
        return db.buscarUsuarioPeloId(id = id);

    }

    //fun buscarPeloEmail(email : String) : String {
      // return db.buscarUsuarioPeloEmail(email = email);
   // }

}