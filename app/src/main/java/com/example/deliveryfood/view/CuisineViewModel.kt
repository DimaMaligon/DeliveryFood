package com.example.deliveryfood.view

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import com.example.deliveryfood.data.CuisineItem
import com.example.deliveryfood.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class CuisineViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    private val listCuisinesMutable: MutableStateFlow<MutableList<CuisineItem>> =
        MutableStateFlow(mutableListOf())
    var listCuisines: StateFlow<List<CuisineItem>> = listCuisinesMutable
    lateinit var disposable: Disposable

    @SuppressLint("CheckResult")
    fun getCuisines() {
        val responseCuisines = repository.getCuisines()

        responseCuisines
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.io())
            .map { response ->
                response.сategories
            }
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getLessonsListObserver())


    }

    private fun getLessonsListObserver(): Observer<List<CuisineItem>> {
        return object : Observer<List<CuisineItem>> {
            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(list: List<CuisineItem>) {
                listCuisinesMutable.value = list as MutableList<CuisineItem>
            }
        }
    }
}