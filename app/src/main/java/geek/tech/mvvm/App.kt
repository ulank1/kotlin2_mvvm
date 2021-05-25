package geek.tech.mvvm

import android.app.Application
import geek.tech.mvvm.di.networkModule
import geek.tech.mvvm.di.repositoryModule
import geek.tech.mvvm.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@App)
            modules(listOf(viewModelModule, repositoryModule, networkModule))
        }
    }

}