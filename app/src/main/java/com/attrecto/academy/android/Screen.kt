package com.attrecto.academy.android

sealed class Screen(val path: String) {

    companion object {
        const val PARAM_ID = "id"
    }

    object List: Screen("list")
    object Detail: Screen("detail/{$PARAM_ID}") {
        fun path(id: String) = "detail/$id"
    }
}