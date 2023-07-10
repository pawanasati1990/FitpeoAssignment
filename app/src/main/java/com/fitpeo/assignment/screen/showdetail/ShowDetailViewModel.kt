package com.fitpeo.assignment.screen.showdetail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel



class ShowDetailViewModel: ViewModel() {
    val titleLiveData=MutableLiveData("")
    val imageUrl=MutableLiveData("")

    fun updateTitle(titleText:String){
        titleLiveData.value=titleText
    }

    fun updateImage(img:String){
        imageUrl.value=img
    }

}