package com.example.lab6_multiplatformapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform