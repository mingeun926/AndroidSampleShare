package com.ymg.sample.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.ymg.sample.domain.entity.Media
import com.ymg.sample.domain.usecase.AddItemUseCase
import com.ymg.sample.domain.usecase.LoadAllItemUseCase
import com.ymg.sample.domain.usecase.RemoveItemUseCase
import com.ymg.sample.domain.usecase.SearchUseCase
import com.ymg.sample.presentation.base.BaseViewModel
import com.ymg.sample.presentation.extention.default
import com.ymg.sample.presentation.ui.adapter.SearchAdapter
import com.ymg.sample.presentation.ui.adapter.StorageAdapter
import com.ymg.sample.presentation.ui.viewstate.MainState
import com.ymg.sample.presentation.util.event.Event



class MainViewModel(
    private val searchUseCase: SearchUseCase,
    loadAllItemUseCase: LoadAllItemUseCase,
    private val addItemUseCase: AddItemUseCase,
    private val removeItemUseCase: RemoveItemUseCase
) : BaseViewModel() {

    // State
    private val _mainState = MutableLiveData<Event<MainState>>()
    val mainState: LiveData<Event<MainState>>
        get() = _mainState

    // SearchAdapter
    private val _searchAdapter by lazy { SearchAdapter() }
    val searchAdapter: SearchAdapter
        get() = _searchAdapter

    // StorageAdapter
    private val _storageAdapter by lazy { StorageAdapter() }
    val storageAdapter: StorageAdapter
        get() = _storageAdapter

    // 검색 데이터
    private val _searchData = MutableLiveData<List<Media>>().default(listOf())
    val searchData: LiveData<List<Media>>
        get() = _searchData

    // 보관 데이터
    val storageData: LiveData<List<Media>> = loadAllItemUseCase().asLiveData()



    /**
     * 검색
     *
     * @param searchWord
     */
    fun search(searchWord: String) {
        setLoading(true)
        searchUseCase(viewModelScope, ioDispatchers, searchWord) {
            _searchData.postValue(it)
            setLoading(false)
        }
    }

    /**
     * 검색 초기화
     */
    fun clearSearch() {
        _searchAdapter.clear()
    }

    /**
     * 저장
     *
     * @param data
     */
    fun addItem(data: Media) {
        setLoading(true)
        addItemUseCase(viewModelScope, ioDispatchers, data) {
            _mainState.postValue(Event(MainState.SUCCESS_SAVE_DATA))
            setLoading(false)
        }
    }

    /**
     * 삭제
     *
     * @param data
     */
    fun removeItem(data: Media) {
        setLoading(true)
        removeItemUseCase(viewModelScope, ioDispatchers, data) {
            _mainState.postValue(Event(MainState.SUCCESS_REMOVE_DATA))
            setLoading(false)
        }
    }
}