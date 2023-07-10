package com.fitpeo.assignment.repository

import com.fitpeo.assignment.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private  val apiHelper: ApiHelper) {
    suspend fun getPhotos() = apiHelper.getPhotos()

}