package com.example.p4_ciudad_pabloalonsosergiorodriguez.data

import android.R
import androidx.annotation.StringRes
import org.maplibre.spatialk.geojson.Position

data class Place(val category: Category, @StringRes val name: Int, @StringRes val description: Int,
                 val position: Position, val urlWeb: String) {
}