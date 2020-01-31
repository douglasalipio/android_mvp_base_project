package com.baseproject.interview.feature.product

import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.feature.product.ProductDtoToProductMapper
import com.baseproject.interview.data.remote.RemoteDataSource
import com.baseproject.interview.di.ActivityScoped
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
abstract class ProductModule {

    @ActivityScoped
    @Binds
    internal abstract fun featurePresenter(presenter: ProductPresenter): ProductContract.Presenter

    @ActivityScoped
    @Binds
    internal abstract fun featureInteractor(interactor: ProductInteractor): ProductContract.Interactor
}