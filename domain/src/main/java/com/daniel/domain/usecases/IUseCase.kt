package com.app.daniel.app.domain.usecases

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


interface IUseCase {
    var disposable : Disposable?
    val compositeDisposable : CompositeDisposable

    fun dispose()
    fun disposeAll()
}