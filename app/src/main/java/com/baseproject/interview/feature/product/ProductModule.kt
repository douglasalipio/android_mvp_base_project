package com.baseproject.interview.feature.product

import com.baseproject.interview.di.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class ProductModule {

    @ActivityScoped
    @Binds
    internal abstract fun featurePresenter(presenter: ProductPresenter): ProductContract.Presenter

    @ActivityScoped
    @Binds
    internal abstract fun featureInteractor(interactor: ProductInteractor): ProductContract.Interactor
}