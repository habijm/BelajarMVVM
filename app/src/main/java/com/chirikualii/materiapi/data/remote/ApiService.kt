package com.chirikualii.materiapi.data.remote

import retrofit2.Response
import retrofit2.http.GET


interface ApiService {

    @GET("movie/now_playing?api_key=3b980052023e8e6898f4578a6972740b&language=en-US&page=1")
    suspend fun getPopularMovie(): Response<PopularMovieResponse>
}