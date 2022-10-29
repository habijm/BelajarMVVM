package com.chirikualii.materiapi.data.repository

import android.util.Log
import com.chirikualii.materiapi.data.model.Movie
import com.chirikualii.materiapi.data.remote.ApiService
import com.google.gson.Gson

class MovieRepoImpl(
    private val service: ApiService
) : MovieRepo {

    override suspend fun getPopularMovie(): List<Movie> {
        try {
            val response = service.getPopularMovie()
            if (response.isSuccessful) {
                val listMovie = response.body()
                val listData = listMovie?.results?.map {
                    Movie(
                        title = it.title,
                        genre = it.releaseDate,
                        imagePoster = it.posterPath
                    )
                }
                Log.d(MovieRepoImpl::class.simpleName, "getPopularMovie: ${Gson().toJsonTree(listData)}")
                return listData ?: emptyList()
            } else {
                Log.e(
                    MovieRepoImpl::class.simpleName,
                    "getPopularMovie error code: ${response.code()} ",)
                return emptyList()
            }

        } catch (e: Exception) {
            Log.e(MovieRepoImpl::class.simpleName, "getPopularMovie error:  ${e.message}",)
            return emptyList()

        }
    }

}