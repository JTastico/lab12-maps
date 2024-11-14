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
    val ArequipaLocation = LatLng(-16.4040102, -71.559611) // Arequipa, Perú
    val context = LocalContext.current
    val iconBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.mountain)
    // Redimensiona el icono a un tamaño más pequeño (ajusta el tamaño según necesites)
    val scaledBitmap = Bitmap.createScaledBitmap(iconBitmap, 100, 100, false)
    val cameraPositionState = rememberCameraPositionState {
        position = com.google.android.gms.maps.model.CameraPosition.fromLatLngZoom(ArequipaLocation, 12f)
    }


    Box(modifier = Modifier.fillMaxSize()) {
        // Añadir GoogleMap al layout
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            // Añadir marcador en Denver, Colorado
            Marker(
                state = rememberMarkerState(position = ArequipaLocation),
                icon = BitmapDescriptorFactory.fromBitmap(scaledBitmap),
                title = "Arequipa, Perú"
            )
        }
    }
}
