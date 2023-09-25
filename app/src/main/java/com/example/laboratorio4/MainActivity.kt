package com.example.laboratorio4
/**
 * Nombre: Sofía Mishell Velasquez
 * Carnet: 22049
 * Proyecto: Laboratorio4
 * Materia: Programación de plataformas moviles
 * Archivo: MainActivity.kt
 * Descripción: aplicación que muestra un recetario con imagen, se puede agregar nuevas recetas, eliminar recetas y no se pueden repetir
 */
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}
data class Evento(val titulo: String, val urlImagen: String, val descripcion: String)
@Composable
fun PrimeraPantalla(eventosFavoritos: List<Evento>, todosLosEventos: List<Evento>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        // Añadido Surface para el fondo del título "TodoEventos"
        item {
            Surface(
                modifier = Modifier.fillMaxWidth().height(50.dp),
                color =  Color(0xFFf8effd)
            ) {
                Text("TodoEventos", style = MaterialTheme.typography.titleLarge,modifier = Modifier.padding(start = 16.dp))
            }
        }

        // Sección de Favoritos
        item {
            Text("Favoritos", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(start = 16.dp))
        }

        // Tarjetas de eventos favoritos, agrupadas de 2 en 2
        items(eventosFavoritos.chunked(2)) { rowItems ->
            LazyRow(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(rowItems) { evento ->
                    EventoCard(evento)
                }
            }
        }

        // Sección de Todos los Eventos
        item {
            Text("Todos los Eventos", style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(start = 16.dp))
        }
        // Tarjetas de eventos favoritos, agrupadas de 2 en 2
        items(todosLosEventos.chunked(2)) { rowItems ->
            LazyRow(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                items(rowItems) { evento ->
                    EventoCard(evento)
                }
            }
        }
    }
}

@Composable
fun EventoCard(evento: Evento) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .width(150.dp)
            .fillMaxHeight(),
        shape = RoundedCornerShape(8.dp)  // Esquinas redondeadas para la tarjeta
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFfadae5)),  // Establece el color de fondo aquí
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = rememberImagePainter(data = evento.urlImagen),
                contentDescription = null,
                modifier = Modifier
                    .height(100.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp)),  // Esquinas redondeadas solo en la parte inferior
                contentScale = ContentScale.Crop
            )
            Text(evento.titulo, style = MaterialTheme.typography.titleSmall)
            Text(evento.descripcion, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val eventosFavoritos = listOf(
        Evento("Concierto Young Miko", "https://cdn.teleticket.com.pe/especiales/young-miko/images/disco-imagen.jpg", "sáb, 9 sept, 14:00 – dom, 10 sept, 17:59\n" + "Explanada Cardales de Cayala\n" + "Cdad. de Guatemala"),
        Evento("Concierto Rauw Alejandro", "https://cdn.teleticket.com.pe/especiales/rauw-alejandro-2023/images/disco-imagen.jpg", "vie, 13 oct, 20:00–23:30\n" + "Explanada Cardales de Cayala\n" + "Cdad. de Guatemala 2"),
        Evento("CNCO", "https://yt3.googleusercontent.com/LIIxOzgZDyhuatsAXH9OYLj4R8cHCVLfpFqSln3WyGK-6yZoRhx3H6-1x-PqMNnC0V6aly8f-w=s900-c-k-c0x00ffffff-no-rj", "sáb, 14 oct, 19:00–23:30\n" + "Forum Majadas\n" + "JCCQ+HWV, Cdad. de Guatemala"),
        Evento("Siddhartha", "https://laopinion.com/wp-content/uploads/sites/3/2023/05/PHOTO-2023-05-22-15-30-53.jpg?quality=75&strip=all&w=1200", "dom, 3 sept, 21:30–23:30\n" + "Parque de la Industria\n" + "JF5G+HFX, 6a Calle, Cdad. de Guatemala")
        )
    val todosLosEventos = listOf(
        Evento("Yoga class Free", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCTUCtSz7eQkH_gt6IztcdFvgUt7y0FjnGim3_-h71Lw&s=10", "sáb, 2 sept, 10:00\n" + "Dentro De 3 Días\n" + "Cdad. de Guatemala"),
        Evento("Evolutionary Astrology — Biomechanics for Joint Health", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjXzblWme1ymBFdYMOqIWgdZ5CDDG16Vn2LkFfzIoXJg&s=10", "vie, 1 sept, 15:00–20:00")
    )
    PrimeraPantalla(eventosFavoritos, todosLosEventos)
}