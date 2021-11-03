package com.attrecto.academy.android.data.api

import retrofit2.http.GET
import retrofit2.http.Query

/*
    5. Feladat
    Retrofit példa:
    https://square.github.io/retrofit/

    A movie API:
    http://www.omdbapi.com/

    - Szerezz api kulcsot az omdbapi-tól
    - Egészítsd ki a keresésnek megfelelő paraméterrel a MovieService-et
    - Cseréld ki a saját api kulcsodra a default paramétert
 */

interface MovieService {
    @GET(".")
    suspend fun search(
        @Query("apiKey") apiKey: String = "a saját kulcsod"
    ): MovieSearchDto
}