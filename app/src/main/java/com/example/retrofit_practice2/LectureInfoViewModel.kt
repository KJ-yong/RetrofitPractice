package com.example.retrofit_practice2

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class LectureInfoViewModel(private val id : Int, private val repository: LectureGetRepository): ViewModel() {
    private val _lectureInfo = MutableLiveData<LectureInfoData>()
    val lectureInfo : LiveData<LectureInfoData>
        get() = _lectureInfo
    init {
        getLectureInfo()
    }
    fun getLectureInfo(){
        viewModelScope.launch {
            _lectureInfo.postValue(repository.loadLectureInfo(id))
        }
    }
}

class LectureInfoViewModelFactory(private val id : Int, private val repository: LectureGetRepository) :
    ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return if (modelClass.isAssignableFrom(LectureInfoViewModel::class.java)) {
                LectureInfoViewModel(id, repository) as T
            } else {
                throw IllegalArgumentException()
            }
        }
}