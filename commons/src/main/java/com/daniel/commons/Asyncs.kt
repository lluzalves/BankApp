package com.daniel.commons

import com.daniel.commons.AppSchedulers.mainThreadScheduler
import com.daniel.commons.AppSchedulers.networkScheduler
import io.reactivex.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Observable<T>.applyScheduler(): Observable<T> = this.compose { observable ->
    observable
        .subscribeOn(networkScheduler())
        .observeOn(mainThreadScheduler())
}

fun <T> Single<T>.applyScheduler(): Single<T> = this.compose { single ->
    single
        .subscribeOn(networkScheduler())
        .observeOn(mainThreadScheduler())
}

object AppSchedulers{

    fun networkScheduler() : Scheduler {
        return Schedulers.io()
    }

    fun mainThreadScheduler() : Scheduler {
        return AndroidSchedulers.mainThread()
    }

}