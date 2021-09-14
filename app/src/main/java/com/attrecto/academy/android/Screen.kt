package com.attrecto.academy.android

sealed class Screen(val route: String) {
    object List : Screen("list")
}