package com.example.retrofit_practice2

import androidx.lifecycle.*
import kotlinx.coroutines.launch

class LectureListViewModel(private val repository: LectureGetRepository) : ViewModel() {
    private val _lectureList = MutableLiveData<ArrayList<Lecture>>()
    private val _page = MutableLiveData<Int>()
    val lectureList: LiveData<ArrayList<Lecture>>
        get() = _lectureList
    val page: LiveData<Int>
        get() = _page
    init {
        _page.value = 1
        getLectureList()
    }
    fun getLectureList(){
        _page.value?.let {
            viewModelScope.launch {
                _lectureList.postValue(repository.loadLectureList(it))
            }
        }
    }
    fun increasePage(){
        _page.value = _page.value?.plus(1)
        getLectureList()
    }
    fun decreasePage(){
        if(_page.value!! > 1){
            _page.value = _page.value?.minus(1)
            getLectureList()
        }
    }
}

class LectureListViewModelFactory(private val repository: LectureGetRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(LectureListViewModel::class.java)) {
            LectureListViewModel(repository) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}