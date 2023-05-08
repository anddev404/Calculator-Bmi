package com.anddev404.calculatorbmi.di

import com.anddev404.calculatorbmi.data.Repository
import org.koin.dsl.module

/**
 * Plik definiujący dostępne moduły wykorzystywane przy wstrzykiwaniu zależności (dependency injection).
 * Wykorzystywana biblioteka to Koin.
 */
val repositoryModules = module {
    single { Repository(get()) }
}
