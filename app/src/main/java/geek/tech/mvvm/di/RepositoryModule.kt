package geek.tech.mvvm.di

import geek.tech.mvvm.data.repository.MainRepo
import org.koin.dsl.module

val repositoryModule = module {
    single { MainRepo(get()) }
}