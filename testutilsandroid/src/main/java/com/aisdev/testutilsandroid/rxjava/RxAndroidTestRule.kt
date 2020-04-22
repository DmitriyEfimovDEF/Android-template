package com.aisdev.testutilsandroid.rxjava

import com.aisdev.testutils.rxjava.RxInit
import com.aisdev.testutils.testrules.after
import com.aisdev.testutils.testrules.before
import io.reactivex.Scheduler
import io.reactivex.android.plugins.RxAndroidPlugins
import io.reactivex.plugins.RxJavaPlugins
import io.reactivex.schedulers.Schedulers

fun rxInitAndroid(block: RxInitAndroid.() -> Unit) =
    before {
        RxInitAndroid().also(block)
    } after {
        RxAndroidPlugins.reset()
        RxAndroidPlugins.setInitMainThreadSchedulerHandler(null)
        RxJavaPlugins.reset()
    }

class RxInitAndroid : RxInit() {

    fun main(scheduler: Scheduler) {
        RxAndroidPlugins.setInitMainThreadSchedulerHandler { Schedulers.trampoline() }
        RxAndroidPlugins.setMainThreadSchedulerHandler { scheduler }
    }

    fun mainTrampoline() {
        main(Schedulers.trampoline())
    }
}
