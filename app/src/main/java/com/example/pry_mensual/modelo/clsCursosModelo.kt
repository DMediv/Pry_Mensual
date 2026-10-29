package com.example.pry_mensual.modelo

class clsCursosModelo {
    suspend fun obternerCursosPorCarrera(carreraId: Int): List<dataCursos>{
        return RetrofitCliente.apiService.obtenerCursos(carreraId)
    }
}