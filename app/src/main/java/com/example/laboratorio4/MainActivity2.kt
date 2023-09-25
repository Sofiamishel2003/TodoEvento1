package com.example.laboratorio4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import kotlin.math.sqrt
class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Laboratorio4Theme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}
data class EventoConLugar(val titulo: String, val lugar: String)

@Composable
fun ListaDeEventos(eventos: List<EventoConLugar>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(eventos) { evento ->
            FilaDeEvento(evento)
            Divider()
        }
    }
}

@Composable
fun FilaDeEvento(evento: EventoConLugar) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color.LightGray.copy(alpha = 0.2f)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Icono circular con la letra inicial del evento
        Surface(
            modifier = Modifier.size(40.dp),
            shape = CircleShape,
            color = Color(0xFFc9bbf7)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = evento.titulo.first().toString(),
                    fontSize = 20.sp,
                    color = Color(0xFF290f7b)
                )
            }
        }

        // Nombre del lugar
        Column(
            //horizontalAlignment = Alignment.Start,
            //verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = evento.titulo,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Text(
                text = evento.lugar,
                fontSize = 16.sp,
                color = Color.Black
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
fun Divider() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.Gray)
    )
}

@Preview(showBackground = true)
@Composable
fun EventoPreview() {
    val eventos = listOf(
        EventoConLugar("Nuns and Roses LA             ", "LA Hall"),
        EventoConLugar("Guns and Roses Denver     ", "Denver Hall"),
        EventoConLugar("Guns and Roses New York", "Maddison Square Garden")
    )
    ListaDeEventos(eventos)
}


