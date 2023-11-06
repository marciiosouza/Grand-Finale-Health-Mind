package br.com.fiap.healfmind.database.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.com.fiap.healfmind.model.Usuarios


@Database(
    entities = [Usuarios::class],
    version = 1
)
abstract class UsuarioDb : RoomDatabase() {

    abstract fun usuarioDao(): UsuarioDao

    companion object{
        private lateinit var instance: UsuarioDb

        fun getDatabase(context: Context): UsuarioDb{
            if(!::instance.isInitialized){
                instance= Room.databaseBuilder(context , UsuarioDb::class.java,"usuario_db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration() // destruir o banco ao inicializar
                    .build()
            }
            return instance
        }
    }
}