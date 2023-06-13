package com.example.deliveryfood.view

import androidx.lifecycle.ViewModel
import com.example.deliveryfood.data.DishItem
import com.example.deliveryfood.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Flowable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DishViewModel @Inject constructor(val repository: Repository) : ViewModel() {
    lateinit var disposable: Disposable
    private val listDishesMutable: MutableStateFlow<MutableList<DishItem>> =
        MutableStateFlow(mutableListOf())
    var listDishes: StateFlow<List<DishItem>> = listDishesMutable
    private val dishChosenMutable = MutableStateFlow(DishItem("", 0, "", "", 0, listOf(), 0))
    val dishChosen: StateFlow<DishItem> = dishChosenMutable

    fun setChosenDish(dish: DishItem) {
        dishChosenMutable.value = dish
    }

    fun getDishes() {
        val responseDishes = repository.getDishes()

        responseDishes
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.io())
            .map { response ->
                response.dishes
            }
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getDishesListObserver())
    }

    fun getDishesByTag(tagDish: String) {
        val responseDishes = repository.getDishes()

        responseDishes
            .onBackpressureBuffer()
            .subscribeOn(Schedulers.io())
            .flatMap { response ->
                Flowable.fromIterable(response.dishes)
            }.filter {
                it.tegs.contains(tagDish)
            }.toList()
            .toObservable()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getDishesListObserver())
    }

    private fun getDishesListObserver(): Observer<List<DishItem>> {
        return object : Observer<List<DishItem>> {
            override fun onComplete() {
            }

            override fun onError(e: Throwable) {
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
            }

            override fun onNext(list: List<DishItem>) {
                listDishesMutable.value = list as MutableList<DishItem>
            }
        }
    }
}