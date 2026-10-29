package com.example.pry_mensual.modelo

class clsCarrerasModelo {
    suspend fun obtenerCarreras(): List<dataCarreras> {
        val datos = RetrofitCliente.apiService.obtenerCarreras()

        val listaFinal = mutableListOf(dataCarreras(0, "Todos los cursos"))
        listaFinal.addAll(datos)

        return listaFinal
    }
}