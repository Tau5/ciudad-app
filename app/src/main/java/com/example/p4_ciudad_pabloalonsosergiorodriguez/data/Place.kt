package com.example.p4_ciudad_pabloalonsosergiorodriguez.data

import androidx.annotation.StringRes
import org.maplibre.spatialk.geojson.Position

data class Place(val category: Category, @StringRes val name: Int, @StringRes val description: Int, val position: Position) {
}