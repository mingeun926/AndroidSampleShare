package com.ymg.sample.presentation.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.orhanobut.logger.BuildConfig
import com.ymg.sample.presentation.util.event.Event
import io.reactivex.rxjava3.disposables.CompositeDisposable
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers



abstract class BaseViewModel : ViewModel() {

    val disposable = CompositeDisposable()

    private val coroutineExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        setLoading(false)
        setExceptionError(throwable.message)

        if (BuildConfig.DEBUG) {
            throwable.printStackTrace()
        }
    }

    protected val ioDispatchers = Dispatchers.IO + coroutineExceptionHandler
    protected val mainDispatchers = Dispatchers.Main + coroutineExceptionHandler

    // Loading
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading

    // Exception Error
    private val _exceptionError = MutableLiveData<Event<String?>>()
    val exceptionError: LiveData<Event<String?>>
        get() = _exceptionError



    override fun onCleared() {
        disposable.dispose()
        //destroyInstance()
        super.onCleared()
    }



    private fun setExceptionError(errorMsg: String? = null) = _exceptionError.postValue(Event(errorMsg))

    fun setLoading(isLoading: Boolean) = _isLoading.postValue(isLoading)
}