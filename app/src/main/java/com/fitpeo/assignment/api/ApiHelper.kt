package com.fitpeo.assignment.api

import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import retrofit2.Response

interface ApiHelper {
    suspend fun getPhotos(): Response<ArrayList<LoadDataItem>>

}