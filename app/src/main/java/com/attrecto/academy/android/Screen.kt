package com.attrecto.academy.android

sealed class Screen(val path: String) {
    object List: Screen("list")
}