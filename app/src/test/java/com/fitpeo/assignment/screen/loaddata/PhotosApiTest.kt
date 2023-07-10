package com.fitpeo.assignment.screen.loaddata

import com.fitpeo.BuildConfig
import com.fitpeo.assignment.api.ApiService
import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotosApiTest {


    lateinit var apiService: ApiService

    @Before
    fun setup() {
        apiService = Retrofit.Builder().baseUrl(BuildConfig.SERVER_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)

    }

    @Test
    fun testPhotosApiResponse() = runTest {
        apiService.getPhotos().let {
            Assert.assertEquals(false, it.body()==null)
            Assert.assertEquals(false, it.body()!!.isEmpty())
            Assert.assertTrue(it.body() is ArrayList<LoadDataItem>)
        }

    }
}