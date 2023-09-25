package com.example.laboratorio4.ui1.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.navigation.NavController

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // DetallesActivity("Sofinga","La mejor del mundo")
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetallesActivity(titulo: String, descripcion: String, navController: NavController) {
    TopAppBar(
        title = { Text("Detalles del Evento") },
        navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás")
            }
        }
    )
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Parte superior en color rosado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
                .background(Color(0xFFf8d3d9))
        ) {
            Text(
                text = "Lugar",
                modifier = Modifier.align(Alignment.BottomStart).padding(start = 16.dp, bottom = 16.dp),
                fontSize = 18.sp
            )
        }

        // Parte inferior en blanco
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Spacer(modifier = Modifier.height((LocalDensity.current.density * 150).dp))
            Text(text = titulo, fontSize = 24.sp)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Icon(Icons.Rounded.DateRange, contentDescription = "Fecha")
                Text("Fecha")  // Simulating an icon for the date, replace with a real one if available
                Text("Hora")
                Text("                             ")

            }

            Text(text = "Información del evento", fontSize = 20.sp)
            Text(text = descripcion, fontSize = 14.sp)
        }

        // Botones en la parte inferior
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter), // Centrar la fila en la parte inferior
            horizontalArrangement = Arrangement.Center // Centrar los elementos dentro de la fila
        ) {
            // Primer botón (Favorite)
            Surface(
                modifier = Modifier
                    .defaultMinSize(minWidth = 150.dp, minHeight = 50.dp)  // Ajustar el tamaño aquí
                    .padding(8.dp),  // Añadir algo de espacio alrededor del botón
                color = Color(0xFFc9bbf7),
                shape = CircleShape
            ) {
                Button(
                    onClick = {},
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)  // Color de fondo del botón
                ) {
                    Text(text = "Favorite", color = Color(0xFF290f7b))
                }
            }

            // Segundo botón (Buy)
            Surface(
                modifier = Modifier
                    .defaultMinSize(minWidth = 150.dp, minHeight = 50.dp)  // Ajustar el tamaño aquí
                    .padding(8.dp),  // Añadir algo de espacio alrededor del botón
                color = Color(0xFFc9bbf7),
                shape = CircleShape
            ) {
                Button(
                    onClick = {},
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)  // Color de fondo del botón
                ) {
                    Text(text = "Buy", color = Color(0xFF290f7b))
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetallesActivityPreview() {

   // DetallesActivity("Sofinga","La mejor del mundo")
}