package com.baseproject.interview.di

import android.app.Application
import com.baseproject.interview.data.AppDataSource
import com.baseproject.interview.data.AppRepository
import com.baseproject.interview.data.feature.product.ProductDtoMapper
import com.baseproject.interview.data.remote.ApiHelper
import com.baseproject.interview.data.remote.RemoteDataSource
import com.baseproject.interview.data.remote.ServiceAppFactory
import com.baseproject.interview.feature.product.view.ProductActivity
import com.baseproject.interview.feature.product.ProductModule
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ActivityScoped
    @ContributesAndroidInjector(modules = [ProductModule::class])
    abstract fun productAcitivity(): ProductActivity
}

@Module
class AppModule {

    @Provides
    @Reusable
    internal fun provideContext(application: Application): Application = application
}

@Module
class RepositoryModule {

    @Provides
    @Reusable
    internal fun provideAppRepository(remoteDataSource: RemoteDataSource): AppDataSource =
        AppRepository(remoteDataSource)

}
@Module
class MapperModule{
    @Provides
    @Reusable
    internal fun provideMapper() = ProductDtoMapper()
}

@Module
class NetworkModule {

    @Provides
    @Reusable
    internal fun provideRemoteRepository(apiHelper: ApiHelper): RemoteDataSource =
        RemoteDataSource(apiHelper)

    @Provides
    @Reusable
    internal fun providePostApi() = ServiceAppFactory.create()
}
