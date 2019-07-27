package com.ucsdextandroid2.android2final.Data

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Route
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

object DataSources {

    private var baseOkHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })
        .build()

    private var baseRetrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://www.songsterr.com/a/ra/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(baseOkHttpClient)
        .build()

    private val api: SongsterrApi = baseRetrofit.create(SongsterrApi::class.java)

    fun search(searchTerm: String, callback: Callback<List<SongsterrChordItem>>) {
        api.getChords(searchTerm).enqueue(object : retrofit2.Callback<List<SongsterrChordItem>> {

            override fun onResponse(
                call: Call<List<SongsterrChordItem>>,
                response: Response<List<SongsterrChordItem>>
            ) {
                callback.onDataFetched(if (response.isSuccessful) response.body().orEmpty() else emptyList())
            }

            override fun onFailure(call: Call<List<SongsterrChordItem>>, t: Throwable) {
                callback.onDataFetched(emptyList<SongsterrChordItem>())
            }

        })
    }

    interface Callback<T> {
        fun onDataFetched(data: T)
    }


    interface SongsterrApi {
        @GET("songs.json")
        fun getChords(
            @Query("pattern") title: String?
        ): Call<List<SongsterrChordItem>>
    }
}