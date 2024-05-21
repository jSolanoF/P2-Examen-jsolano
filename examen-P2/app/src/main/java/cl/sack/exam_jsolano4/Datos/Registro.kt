package cl.sack.exam_jsolano4.Datos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Registro(
    @PrimaryKey(autoGenerate = true) val id:Int = 0,
    var medidor: Int,
    var fecha:String,
    val option:String

)
