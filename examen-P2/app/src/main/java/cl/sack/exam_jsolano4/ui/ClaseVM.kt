package cl.sack.exam_jsolano4.ui
import android.content.Context
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import cl.sack.exam_jsolano4.Datos.DataBase
import cl.sack.exam_jsolano4.Datos.Registro

class ClaseVM : ViewModel() {

    var itemList = mutableStateListOf<Registro>()

    suspend fun registrarMedicion(medida: String, fecha: String, opcion: String, contexto:Context) {
        if (!medida.isNullOrBlank() && !fecha.isNullOrBlank() && !opcion.isNullOrBlank()){
            val reg = Registro(medidor = medida.toInt(), fecha = fecha, option = opcion)
            itemList.add(reg)
            DataBase.getInstance(contexto).dataDao().insertarRegistro(reg)
        }
    }

    suspend fun mostrarListado(contexto: Context) {
        itemList.clear()
        itemList.addAll(DataBase.getInstance(contexto).dataDao().obtenerRegistro())
    }

    suspend fun borrarRegistro(contexto:Context, registro: Registro) {
        DataBase.getInstance(contexto).dataDao().borrarRegistro(registro)
        mostrarListado(contexto)
    }
}
