package com.example.laboratorio4.navegacion

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter

@ExperimentalMaterial3Api
@Composable
fun PantallaLogin(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        // Logo
        Image(
            painter = rememberImagePainter("url_del_logo"),
            contentDescription = "Logo",
            modifier = Modifier.size(100.dp)
        )

        // Input para el usuario
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        // Input para la contraseña
        TextField(
            value = "",
            onValueChange = {},
            label = { Text("Contraseña") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        )

        // Botón de inicio de sesión
        Button(onClick = {
            // Navegar a la pantalla de pestañas y eliminar esta pantalla del stack
            navController.navigate("tabs") {
                popUpTo("login") { inclusive = true }
            }
        }) {
            Text("Iniciar sesión")
        }
    }
}

