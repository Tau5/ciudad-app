package com.example.p4_ciudad_pabloalonsosergiorodriguez.data

import com.example.p4_ciudad_pabloalonsosergiorodriguez.R
import org.maplibre.spatialk.geojson.Position


data object DataSource {

    val places: List<Place> = listOf(
        Place(
            category = Category.Deporte,
            name = R.string.prado,
            description = R.string.pradoDesc,
            position = Position(longitude = -3.692127, latitude = 40.413780),
            urlWeb = "https://www.museodelprado.es/en"
        ),
    )

    val ciudades: List<City> = listOf(
        City(
            name = R.string.madrid,
            places = places,
            position = Position(longitude = -3.7, latitude = 40.416667 ),
        )
    )
}