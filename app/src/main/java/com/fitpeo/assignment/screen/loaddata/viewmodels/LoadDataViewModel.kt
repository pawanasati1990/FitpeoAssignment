package com.fitpeo.assignment.screen.loaddata.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fitpeo.assignment.other.Resource
import com.fitpeo.assignment.repository.MainRepository
import com.fitpeo.assignment.screen.loaddata.models.LoadDataItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoadDataViewModel @Inject constructor(private  val mainRepository: MainRepository):ViewModel() {
    private val _res = MutableLiveData<Resource<ArrayList<LoadDataItem>>>()

    val res : LiveData<Resource<ArrayList<LoadDataItem>>>
        get() = _res

    init {
        getAllPhotos()
    }

    fun getClickedItem(pos:Int): LoadDataItem? {
        return res.value?.data?.let {
            it[pos]
        }
    }


    private fun getAllPhotos()  = viewModelScope.launch {
        _res.postValue(Resource.loading(null))
        mainRepository.getPhotos().let {
            if (it.isSuccessful){
                _res.postValue(Resource.success(it.body()))
            }else{
               _res.postValue(Resource.error(it.errorBody().toString(), null))
           }
        }
    }


}