package com.example.laboratorio4.navegacion


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.laboratorio4.ui1.concerts.Evento
import com.example.laboratorio4.ui1.concerts.PrimeraPantalla
import com.example.laboratorio4.ui1.detail.DetallesActivity
import com.example.laboratorio4.ui1.places.MainActivity2
import com.example.laboratorio4.ui1.profile.MainActivity4
import com.example.laboratorio4.ui1.favorites.PantallaFavoritos
import com.example.laboratorio4.ui1.places.EventoConLugar
import com.example.laboratorio4.ui1.places.ListaDeEventos
import com.example.laboratorio4.ui1.profile.Pantalla

@Composable
fun Navigation() {
    val navController = rememberNavController()
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
    val eventos = listOf(
        EventoConLugar("Nuns and Roses LA             ", "LA Hall"),
        EventoConLugar("Guns and Roses Denver     ", "Denver Hall"),
        EventoConLugar("Guns and Roses New York", "Maddison Square Garden")
    )
    val selectedTabIndex = remember { mutableStateOf(0) }

    NavHost(navController, startDestination = "tabs") {
        composable("tabs") {
            Column {
                TabRow(selectedTabIndex = selectedTabIndex.value) {
                    Tab(selected = selectedTabIndex.value == 0, onClick = { selectedTabIndex.value = 0 }) {
                        Text("Eventos")
                    }
                    Tab(selected = selectedTabIndex.value == 1, onClick = { selectedTabIndex.value = 1 }) {
                        Text("Lugares")
                    }
                    Tab(selected = selectedTabIndex.value == 2, onClick = { selectedTabIndex.value = 2 }) {
                        Text("Perfil")
                    }
                    Tab(selected = selectedTabIndex.value == 3, onClick = { selectedTabIndex.value = 3 }) {
                        Text("Favoritos")
                    }
                }

                when (selectedTabIndex.value) {
                    0 -> PrimeraPantalla(eventosFavoritos, todosLosEventos) { evento ->
                        navController.navigate("detalleEvento/${evento.titulo}/${evento.descripcion}")
                    }
                    1 -> ListaDeEventos(eventos) // Tu implementación para MainActivity2
                    2 -> Pantalla() // Tu implementación para MainActivity4
                    3 -> PantallaFavoritos(eventosFavoritos)  // Implementación para MainActivity5
                }
            }
        }
        composable("detalleEvento/{titulo}/{descripcion}") { backStackEntry ->
            val titulo = backStackEntry.arguments?.getString("titulo") ?: ""
            val descripcion = backStackEntry.arguments?.getString("descripcion") ?: ""
            DetallesActivity(titulo, descripcion, navController)  // Aquí pasamos el NavController
        }
    }
}