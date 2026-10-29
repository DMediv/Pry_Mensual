package com.example.pry_mensual.modelo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable

data class dataCarreras(
    @SerialName(value = "id") val id: Int=0,
    @SerialName(value = "carrera") val carrera: String
)
{
    override fun toString(): String {
        return carrera
    }
}