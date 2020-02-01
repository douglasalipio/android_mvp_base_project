package com.baseproject.interview.feature.productdetail

import com.baseproject.interview.di.ActivityScoped
import dagger.Binds
import dagger.Module

@Module
abstract class ProductDetailModule {

    @ActivityScoped
    @Binds
    internal abstract fun featurePresenter(presenter: ProductDetailPresenter): ProductDetailContract.Presenter

    @ActivityScoped
    @Binds
    internal abstract fun featureInteractor(interactor: ProductDetailInteractor): ProductDetailContract.Interactor
}