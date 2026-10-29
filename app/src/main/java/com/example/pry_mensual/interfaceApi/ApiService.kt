package com.example.pry_mensual.interfaceApi

import com.example.pry_mensual.modelo.dataCarreras
import com.example.pry_mensual.modelo.dataCursos
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("obtener_carreras.php")
    suspend fun obtenerCarreras(): List<dataCarreras>
    @GET("obtener_cursos.php")
    suspend fun obtenerCursos(@Query("carrera_id") carreraId : Int): List<dataCursos>
}