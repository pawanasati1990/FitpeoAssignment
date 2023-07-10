package com.fitpeo.assignment.api

import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private  val apiService: ApiService):ApiHelper{
    override suspend fun getPhotos(): Response<ArrayList<LoadDataItem>> =apiService.getPhotos()
}