package cl.sack.exam_jsolano4.Datos

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Dao {

    @Insert
    suspend fun insertarRegistro(registro:Registro)

    @Query("SELECT * FROM registro")
    suspend fun obtenerRegistro():List<Registro>

    @Delete
    suspend fun borrarRegistro(registro:Registro)

}