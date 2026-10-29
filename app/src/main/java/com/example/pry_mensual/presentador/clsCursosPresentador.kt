package com.example.pry_mensual.presentador

import com.example.pry_mensual.vista.MainActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.pry_mensual.modelo.clsCursosModelo
import com.example.pry_mensual.modelo.clsCarrerasModelo
import com.example.pry_mensual.modelo.dataCarreras

class clsCursosPresentador(private val vista: MainActivity) {
    private val modelo = clsCarrerasModelo()
    private var listaCarreras: List<dataCarreras> = emptyList()
    private val modeloProductos = clsCursosModelo()

    fun iniciar() {

        CoroutineScope(Dispatchers.Main).launch {

            try {
                listaCarreras=modelo.obtenerCarreras()
                vista.mostrarCarreras(listaCarreras)
                cargarCursos(0)
            } catch (e: Exception) {
                vista.mostrarError("Error: "+ e.localizedMessage)
            }
        }
    }
    fun seleccionarCarrera(posicion: Int) {
        if (posicion >= 0 && posicion < listaCarreras.size) {
            val carrera = listaCarreras[posicion]
            cargarCursos(carrera.id)
        }
    }
    private fun cargarCursos(carreraId: Int){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                val cursos = modeloProductos.obternerCursosPorCarrera(carreraId)
                vista.mostrarCursos(cursos)
            }catch (e: Exception){
                vista.mostrarError("Error al cargar cursos"+e.localizedMessage)
            }
        }
    }
}