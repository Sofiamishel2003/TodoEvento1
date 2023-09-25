package com.example.laboratorio4.ui1.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import kotlin.math.sqrt


class MainActivity4 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pantalla()
        }
    }
}

@Composable
fun Pantalla() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Parte superior de imagen e icono
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
        ) {
            Image(
                painter = rememberImagePainter("https://images.unsplash.com/photo-1615715874994-bb83092ef331?ixlib=rb-1.2.1&auto=format&fit=crop&w=1950&q=80"),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Icon(Icons.Rounded.Person, contentDescription = null,
                modifier = Modifier.align(Alignment.Center).size(50.dp))
            Text(
                text = "Sofía Velásquez",
                modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 16.dp),
                fontSize = 18.sp
            )
        }

        // Filas de información
        Fila("Edit Profile", "P")
        Fila("Reset Password", "R")
        Fila("Notifications", "N")
        Fila("Favorites", "F")
    }
}
@Composable
fun Fila(texto: String, iconoT: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Contenedor del icono y texto
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Icono de la fila
            Surface(
                modifier = Modifier.size(40.dp),
                shape = CircleShape,
                color = Color(0xFFc9bbf7)
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    when (iconoT) {
                        "P" -> Icon(Icons.Rounded.Person, contentDescription = "Persona")
                        "R" -> Icon(Icons.Rounded.Lock, contentDescription = "Cerradura")
                        "N" -> Icon(Icons.Rounded.Notifications, contentDescription = "Notificaciones")
                        else -> Icon(Icons.Rounded.Star, contentDescription = "Estrella")
                    }
                }
            }
            // Nombre del campo
            Text(
                text = texto,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(start = 16.dp)
            )
        }

        // Triángulo al final
        Canvas(modifier = Modifier.size(16.dp)) {
            val path = Path()
            val side = size.minDimension
            val height = side * (sqrt(3.0) / 2).toFloat()
            val startY = (size.height - height) / 2
            val startX = size.width / 2

            path.moveTo(startX, startY)
            path.lineTo(startX - side / 2, startY + height)
            path.lineTo(startX + side / 2, startY + height)
            path.close()

            drawPath(path, Color.DarkGray, style = Stroke(width = 5f))
        }
    }
}


@Composable
fun Divisor() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(5.dp)
            .background(Color.Gray)
    )
}
@Preview(showBackground = true)
@Composable
fun PreviewAppVidaSaludable() {
    Laboratorio4Theme {
        Pantalla()
    }
}
