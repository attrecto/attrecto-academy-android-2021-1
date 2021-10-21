package com.attrecto.academy.android

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun DetailsScreen(id: String?) {
    Text(text = id ?: "üres")
}