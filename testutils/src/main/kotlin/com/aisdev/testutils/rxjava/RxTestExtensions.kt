package com.aisdev.testutils.rxjava

import io.reactivex.Observable

fun <T> T.just(): Observable<T> = Observable.just(this)
