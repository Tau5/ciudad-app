package com.example.p4_ciudad_pabloalonsosergiorodriguez.data

import androidx.annotation.StringRes
import com.example.p4_ciudad_pabloalonsosergiorodriguez.R

enum class Category(@StringRes val nombre: Int) {
    Restauracion(nombre = R.string.restauracion),
    Cultura(nombre = R.string.cultura),
    Deporte(nombre = R.string.deporte),
    Ocio(nombre = R.string.ocio)
}