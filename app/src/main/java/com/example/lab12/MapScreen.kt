package com.example.lab12

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Circle
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Polygon
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapScreen() {
    val mallAventuraPolygon = listOf(
        LatLng(-16.432292, -71.509145),
        LatLng(-16.432757, -71.509626),
        LatLng(-16.433013, -71.509310),
        LatLng(-16.432566, -71.508853)
    )

    val parqueLambramaniPolygon = listOf(
        LatLng(-16.422704, -71.530830),
        LatLng(-16.422920, -71.531340),
        LatLng(-16.423264, -71.531110),
        LatLng(-16.423050, -71.530600)
    )

    val plazaDeArmasPolygon = listOf(
        LatLng(-16.398866, -71.536961),
        LatLng(-16.398744, -71.536529),
        LatLng(-16.399178, -71.536289),
        LatLng(-16.399299, -71.536721)
    )

    // Configuración inicial de la cámara
    val cameraPositionState = rememberCameraPositionState {
        this.position = CameraPosition.fromLatLngZoom(
            LatLng(-16.398866, -71.536961), 13f
        )
    }

    Box(modifier = Modifier.fillMaxSize()) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            // Dibujar polígonos
            Polygon(
                points = mallAventuraPolygon,
                strokeColor = Color.Red,
                fillColor = Color(0x550000FF), // Azul semitransparente
                strokeWidth = 5f
            )
            Polygon(
                points = parqueLambramaniPolygon,
                strokeColor = Color.Green,
                fillColor = Color(0x5500FF00), // Verde semitransparente
                strokeWidth = 5f
            )
            Polygon(
                points = plazaDeArmasPolygon,
                strokeColor = Color.Yellow,
                fillColor = Color(0x55FFFF00), // Amarillo semitransparente
                strokeWidth = 5f
            )

            // Añadir círculos en los puntos de cada polígono
            val allPolygons = listOf(
                mallAventuraPolygon,
                parqueLambramaniPolygon,
                plazaDeArmasPolygon
            )
            allPolygons.forEach { polygon ->
                polygon.forEach { point ->
                    Circle(
                        center = point,
                        radius = 20.0, // Radio en metros (ajustar según necesidad)
                        strokeColor = Color.Black,
                        fillColor = Color.Red
                    )
                }
            }
        }
    }
}
