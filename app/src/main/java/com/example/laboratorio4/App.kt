package com.example.laboratorio4

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import com.example.laboratorio4.navegacion.Navigation
import com.example.laboratorio4.ui.theme.Laboratorio4Theme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier

@Composable
fun App() {
    Laboratorio4Theme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Navigation()
        }
    }
}
