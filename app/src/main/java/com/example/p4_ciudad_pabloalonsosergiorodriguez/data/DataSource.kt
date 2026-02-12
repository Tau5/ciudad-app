package com.example.p4_ciudad_pabloalonsosergiorodriguez.data

import com.example.p4_ciudad_pabloalonsosergiorodriguez.R
import org.maplibre.spatialk.geojson.Position


data object DataSource {

    val placesMadrid: List<Place> = listOf(
        Place(
            category = Category.Cultura,
            name = R.string.prado,
            description = R.string.pradoDesc,
            position = Position(longitude = -3.692127, latitude = 40.413780),
            urlWeb = "https://www.museodelprado.es/en",
            img = R.drawable.museo_prado_madrid_museum_36335796
        ),
        Place(
            category = Category.Ocio,
            name = R.string.parqueAtracciones,
            description = R.string.parqueAtraccionesDesc,
            position = Position(
                longitude = -3.751789,
                latitude = 40.411289
            ),
            urlWeb = "https://www.parquedeatracciones.es/",
            img = R.drawable._fb3faec_d6cf_4124_9d0c_e9adce46f56c_632918796
        ),
        Place(
            category = Category.Cultura,
            name = R.string.caixaForum,
            description = R.string.caixaForumDesc,
            position = Position(
                longitude = -3.0412104,
                latitude = 40.242378
            ),
            urlWeb = "https://caixaforum.org/es/madrid",
            img = R.drawable.facade_du_caixaforum_madrid_3038184001
        ),
        Place(
            category = Category.Deporte,
            name = R.string.urbanPlanet,
            description = R.string.urbanPlanetDesc,
            position = Position(
                longitude = -3.5813311,
                latitude = 40.4444008
            ),
            urlWeb = "https://urbanplanetjump.es/parques/las-rejas/",
            img = R.drawable.c870x524_338597640
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.numa,
            description = R.string.numaDesc,
            position = Position(
                longitude = -3.6839974,
                latitude = 40.4233521
            ),
            urlWeb = "https://restaurantenuma.com/",
            img = R.drawable.estgallardo_apomboint_numapomp_128_editar_1284x850_q75_middle_1967589061
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.cerveceriaLaAvenida,
            description = R.string.cerveceriaLaAvenidaDesc,
            position = Position(
                longitude = -3.6475,
                latitude = 40.3848
            ),
            urlWeb = "http://laavenidavk.es/",
            img = R.drawable.shutterstock_1676609173_scaled_3873999629
        ),
        Place(
            category = Category.Ocio,
            name = R.string.fabrik,
            description = R.string.fabrikDesc,
            position = Position(
                longitude = -3.8405,
                latitude = 40.2655
            ),
            urlWeb = "https://www.fabrikmadrid.com/",
            img = R.drawable.fabrik_madrid_1639657008_8639052_2560x1440_3875067577
        ),
        Place(
            category = Category.Deporte,
            name = R.string.palacioHielo,
            description = R.string.palacioHieloDesc,
            position = Position(
                longitude = -3.6379,
                latitude = 40.4630
            ),
            urlWeb = "https://pistadehielomadrid.es/",
            img = R.drawable.cine_palacio_de_hielo_3746133686
        ),
        Place(
            category = Category.Cultura,
            name = R.string.palacioReal,
            description = R.string.palacioRealDesc,
            position = Position(
                longitude = -3.7143,
                latitude = 40.4179
            ),
            urlWeb = "https://www.patrimonionacional.es/visita/palacio-real-de-madrid",
            img = R.drawable.palacio_real_cabecera_fachada_principal_
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.rosiLaLoca,
            description = R.string.rosiLaLocaDesc,
            position = Position(
                longitude = -3.7030,
                latitude = 40.4158
            ),
            urlWeb = "https://rosilaloca.com/",
            img = R.drawable.rosi_la_loca_1024x576_1536243373
        )
    )

    val placesBerlin: List<Place> = listOf(
        Place(
            category = Category.Cultura,
            name = R.string.brandenburgGate,
            description = R.string.brandenburgGateDesc,
            position = Position(longitude = 13.377704, latitude = 52.516275),
            urlWeb = "https://www.berlin.de/en/attractions-and-sights/3560266-3104052-brandenburg-gate.en.html",
            img = R.drawable.puerta_de_brandenburgo_berlin_1182693775
        ),
        Place(
            category = Category.Cultura,
            name = R.string.museumIsland,
            description = R.string.museumIslandDesc,
            position = Position(longitude = 13.401417, latitude = 52.516889),
            urlWeb = "https://www.smb.museum/en/museums-institutions/museumsinsel-berlin/home/",
            img = R.drawable.isla_museos_berlin_3347013736
        ),
        Place(
            category = Category.Ocio,
            name = R.string.tiergarten,
            description = R.string.tiergartenDesc,
            position = Position(longitude = 13.3500, latitude = 52.5145),
            urlWeb = "https://www.berlin.de/en/parks-and-gardens/3560778-4407152-tiergarten.en.html",
            img = R.drawable._5101_tiergarten_1350980474
        ),
        Place(
            category = Category.Deporte,
            name = R.string.olympiastadion,
            description = R.string.olympiastadionDesc,
            position = Position(longitude = 13.239444, latitude = 52.514722),
            urlWeb = "https://olympiastadion.berlin/en/",
            img = R.drawable.estadio_olimpico_de_berlin_2986521714
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.hofbraeuBerlin,
            description = R.string.hofbraeuBerlinDesc,
            position = Position(longitude = 13.4131, latitude = 52.5219),
            urlWeb = "https://www.hofbraeu-wirtshaus.de/berlin/",
            img = R.drawable.berlin_4860600_1280_4253366345
        ),
        Place(
            category = Category.Cultura,
            name = R.string.eastSideGallery,
            description = R.string.eastSideGalleryDesc,
            position = Position(longitude = 13.4397, latitude = 52.5050),
            urlWeb = "https://www.eastsidegallery-berlin.com/",
            img = R.drawable.east_side_gallery_berlijn_3496_xl_208289179
        ),
        Place(
            category = Category.Cultura,
            name = R.string.checkpointCharlie,
            description = R.string.checkpointCharlieDesc,
            position = Position(longitude = 13.3904, latitude = 52.5074),
            urlWeb = "https://www.berlin.de/en/attractions-and-sights/3560059-3104052-checkpoint-charlie.en.html",
            img = R.drawable.checkpoint_charlie_ancien_point_de_controle_frontalier_a_berlin_allemagne_2517116604
        ),
        Place(
            category = Category.Ocio,
            name = R.string.alexanderplatz,
            description = R.string.alexanderplatzDesc,
            position = Position(longitude = 13.4133, latitude = 52.5219),
            urlWeb = "https://www.berlin.de/en/attractions-and-sights/3560262-3104052-alexanderplatz.en.html",
            img = R.drawable.alexanderplatz_gesamtansicht_bit_2294_3306820012
        ),
        Place(
            category = Category.Cultura,
            name = R.string.berlinerDom,
            description = R.string.berlinerDomDesc,
            position = Position(longitude = 13.4011, latitude = 52.5190),
            urlWeb = "https://www.berlinerdom.de/en/",
            img = R.drawable.berlin_wide_2_3062856324
        ),
        Place(
            category = Category.Ocio,
            name = R.string.potsdamerPlatz,
            description = R.string.potsdamerPlatzDesc,
            position = Position(longitude = 13.3761, latitude = 52.5096),
            urlWeb = "https://www.berlin.de/en/attractions-and-sights/3560564-3104052-potsdamer-platz.en.html",
            img = R.drawable.berlinpotsdamerplatzsonycentergettyimages_910195760luispinaphotogrpahy_5bd898b8c9e77c00511b7671_1844921984
        )
    )

    val placesBuenosAires: List<Place> = listOf(
        Place(
            category = Category.Cultura,
            name = R.string.teatroColon,
            description = R.string.teatroColonDesc,
            position = Position(longitude = -58.382222, latitude = -34.601111),
            urlWeb = "https://teatrocolon.org.ar/en",
            img = R.drawable._200px_fachada_del_teatro_col_n_en_buenos_aires__argentina_2206917773
        ),
        Place(
            category = Category.Cultura,
            name = R.string.obelisco,
            description = R.string.obeliscoDesc,
            position = Position(longitude = -58.381592, latitude = -34.603722),
            urlWeb = "https://turismo.buenosaires.gob.ar/en/atractivo/obelisco",
            img = R.drawable.buenos_aires___obelisco_141127878
        ),
        Place(
            category = Category.Ocio,
            name = R.string.caminito,
            description = R.string.caminitoDesc,
            position = Position(longitude = -58.362778, latitude = -34.639444),
            urlWeb = "https://turismo.buenosaires.gob.ar/en/atractivo/caminito",
            img = R.drawable.el_caminito_buenos_aires_1585234704
        ),
        Place(
            category = Category.Deporte,
            name = R.string.laBombonera,
            description = R.string.laBomboneraDesc,
            position = Position(longitude = -58.364756, latitude = -34.635614),
            urlWeb = "https://www.bocajuniors.com.ar/el-club/la-bombonera",
            img = R.drawable.la_bombonera_3829533846
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.donJulio,
            description = R.string.donJulioDesc,
            position = Position(longitude = -58.4247, latitude = -34.5866),
            urlWeb = "https://www.parrilladonjulio.com/",
            img = R.drawable.don_julio_buenos_aires__2645816422
        ),
        Place(
            category = Category.Ocio,
            name = R.string.puertoMadero,
            description = R.string.puertoMaderoDesc,
            position = Position(longitude = -58.3633, latitude = -34.6118),
            urlWeb = "https://turismo.buenosaires.gob.ar/en/atractivo/puerto-madero",
            img = R.drawable._269218247_521249841a_o_947442971
        ),
        Place(
            category = Category.Ocio,
            name = R.string.jardinJapones,
            description = R.string.jardinJaponesDesc,
            position = Position(longitude = -58.4108, latitude = -34.5753),
            urlWeb = "https://jardinjapones.org.ar/",
            img = R.drawable.visita_jardin_japones_buenos_aires_2021_32_min_2393110676
        ),
        Place(
            category = Category.Cultura,
            name = R.string.cementerioRecoleta,
            description = R.string.cementerioRecoletaDesc,
            position = Position(longitude = -58.3913, latitude = -34.5876),
            urlWeb = "https://turismo.buenosaires.gob.ar/en/atractivo/cementerio-de-la-recoleta",
            img = R.drawable.buenos_aires___cementerio_de_la_recoleta___200808a_1024_4246038297
        ),
        Place(
            category = Category.Cultura,
            name = R.string.plazaDeMayo,
            description = R.string.plazaDeMayoDesc,
            position = Position(longitude = -58.3703, latitude = -34.6083),
            urlWeb = "https://turismo.buenosaires.gob.ar/en/atractivo/plaza-de-mayo",
            img = R.drawable.plaza_de_mayo_2305130656
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.mercadoSanTelmo,
            description = R.string.mercadoSanTelmoDesc,
            position = Position(longitude = -58.3733, latitude = -34.6208),
            urlWeb = "http://mercadosantelmo.com.ar/",
            img = R.drawable.mercado_de_san_telmo_2403377917
        )
    )

    val placesAuckland: List<Place> = listOf(
        Place(
            category = Category.Ocio,
            name = R.string.skyTower,
            description = R.string.skyTowerDesc,
            position = Position(longitude = 174.763336, latitude = -36.848461),
            urlWeb = "https://skycityauckland.co.nz/sky-tower/",
            img = R.drawable.sky_tower_1354155_3159016937
        ),
        Place(
            category = Category.Cultura,
            name = R.string.aucklandMuseum,
            description = R.string.aucklandMuseumDesc,
            position = Position(longitude = 174.7772, latitude = -36.8605),
            urlWeb = "https://www.aucklandmuseum.com/",
            img = R.drawable.los_7_mejores_museos_de_auckland_nueva_zelanda_2420469590
        ),
        Place(
            category = Category.Ocio,
            name = R.string.mountEden,
            description = R.string.mountEdenDesc,
            position = Position(longitude = 174.7640, latitude = -36.8763),
            urlWeb = "https://www.aucklandnz.com/visit/destinations/auckland-central/mount-eden",
            img = R.drawable._002269_mount_eden_auckland_48280121
        ),
        Place(
            category = Category.Deporte,
            name = R.string.edenPark,
            description = R.string.edenParkDesc,
            position = Position(longitude = 174.743333, latitude = -36.875556),
            urlWeb = "https://edenpark.co.nz/",
            img = R.drawable.eden_park_new_zealand_3077304951
        ),
        Place(
            category = Category.Restauracion,
            name = R.string.theGrove,
            description = R.string.theGroveDesc,
            position = Position(longitude = 174.7653, latitude = -36.8489),
            urlWeb = "https://www.thegroverestaurant.co.nz/",
            img = R.drawable.the_grove_v1_931506198
        ),
        Place(
            category = Category.Ocio,
            name = R.string.waihekeIsland,
            description = R.string.waihekeIslandDesc,
            position = Position(longitude = 175.0433, latitude = -36.7861),
            urlWeb = "https://www.tourismwaiheke.co.nz/",
            img = R.drawable._58915_waiheke_island_new_zealand_3806563843
        ),
        Place(
            category = Category.Ocio,
            name = R.string.viaductHarbour,
            description = R.string.viaductHarbourDesc,
            position = Position(longitude = 174.7633, latitude = -36.8425),
            urlWeb = "https://www.viaduct.co.nz/",
            img = R.drawable._3ed29c3a228ee14cbfc401e_viaduct_harbour_marina___home__header_image_2445466306
        ),
        Place(
            category = Category.Cultura,
            name = R.string.aucklandArtGallery,
            description = R.string.aucklandArtGalleryDesc,
            position = Position(longitude = 174.7661, latitude = -36.8511),
            urlWeb = "https://www.aucklandartgallery.com/",
            img = R.drawable.auckland_art_gallery_new_zealand_picture_id537399242_2668559124
        ),
        Place(
            category = Category.Ocio,
            name = R.string.kellyTarltons,
            description = R.string.kellyTarltonsDesc,
            position = Position(longitude = 174.8175, latitude = -36.8475),
            urlWeb = "https://www.kellytarltons.co.nz/",
            img = R.drawable.kelly_tarltons_sea_life_aquarium_257138843
        ),
        Place(
            category = Category.Ocio,
            name = R.string.oneTreeHill,
            description = R.string.oneTreeHillDesc,
            position = Position(longitude = 174.7833, latitude = -36.9000),
            urlWeb = "https://www.aucklandnz.com/visit/destinations/auckland-central/one-tree-hill",
            img = R.drawable.estadio_olimpico_berlin_15062024in3_1816025281
        )
    )

    val cities: List<City> = listOf(
        City(
            name = R.string.madrid,
            places = placesMadrid,
            position = Position(longitude = -3.7, latitude = 40.416667 ),
        ),
        City(
            name = R.string.berlin,
            places = placesBerlin,
            position = Position(longitude = 13.4050, latitude = 52.5200),
        ),
        City(
            name = R.string.buenosAires,
            places = placesBuenosAires,
            position = Position(longitude = -58.3816, latitude = -34.6037),
        ),
        City(
            name = R.string.auckland,
            places = placesAuckland,
            position = Position(longitude = 174.7633, latitude = -36.8485),
        )
    )
}