package com.example.p4_ciudad_pabloalonsosergiorodriguez.data

import androidx.annotation.StringRes
import org.maplibre.spatialk.geojson.Position

data class City(@StringRes val name: Int, val places: List<Place>, val position: Position) {
}
