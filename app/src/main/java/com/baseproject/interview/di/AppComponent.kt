package com.baseproject.interview.di

import com.baseproject.interview.AppApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityModule::class,
        NetworkModule::class,
        MapperModule::class,
        RepositoryModule::class]
)
interface AppComponent : AndroidInjector<AppApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: AppApplication): Builder

        fun build(): AppComponent
    }
}

