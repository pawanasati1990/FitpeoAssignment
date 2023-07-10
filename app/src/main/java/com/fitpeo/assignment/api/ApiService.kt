package com.fitpeo.assignment.api

import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("photos")
    suspend fun getPhotos(): Response<ArrayList<LoadDataItem>>
}