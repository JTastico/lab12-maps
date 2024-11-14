package com.example.lab12

import android.graphics.BitmapFactory
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.Marker
import android.graphics.Bitmap
import androidx.compose.ui.platform.LocalContext

@Composable
fun MapScreen() {
    val locations = listOf(
        LatLng(-16.433415,-71.5442652), // JLByR
        LatLng(-16.4205151,-71.4945209), // Paucarpata
        LatLng(-16.3524187,-71.5675994) // Zamacola // Arequipa, Perú
    )
    val context = LocalContext.current
    //val iconBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mountain)
    // Redimensiona el icono a un tamaño más pequeño (ajusta el tamaño según necesites)
    //val scaledBitmap = Bitmap.createScaledBitmap(iconBitmap, 100, 100, false)


    Box(modifier = Modifier.fillMaxSize()) {
        // Añadir GoogleMap al layout
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
        ) {
            // Añadir marcador en Denver, Colorado
            locations.forEach { location ->
                Marker(
                    state = rememberMarkerState(position = location),
                    title = "Ubicación",
                    snippet = "Punto de interés"
                )
            }
        }
    }
    }
