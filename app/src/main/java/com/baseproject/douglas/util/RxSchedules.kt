package com.baseproject.douglas.util

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun computation(): Scheduler = Schedulers.computation()

fun io(): Scheduler = Schedulers.io()

fun ui(): Scheduler = AndroidSchedulers.mainThread()

fun synComputation(): Scheduler = Schedulers.trampoline()

fun syncIo(): Scheduler = Schedulers.trampoline()

fun syncUi(): Scheduler = Schedulers.trampoline()
