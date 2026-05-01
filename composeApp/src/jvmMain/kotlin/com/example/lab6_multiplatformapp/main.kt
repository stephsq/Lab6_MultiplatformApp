package com.example.lab6_multiplatformapp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Lab6_MultiplatformApp",
    ) {
        App()
    }
}