package com.daniel.domain.repositories

import io.reactivex.Single

interface Repository<T> {
    fun retrieveListOf(): Single<List<T>>
    fun retrieveItem() : T
}