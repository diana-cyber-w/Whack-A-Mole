package com.example.whac_a_mole

import android.content.Context
import com.example.whac_a_mole.data.di.DataModule
import com.example.whac_a_mole.domain.di.DomainModule
import com.example.whac_a_mole.presentation.di.ViewModelModule
import com.example.whac_a_mole.presentation.fragments.GameFragment
import com.example.whac_a_mole.presentation.fragments.ResultFragment
import com.example.whac_a_mole.presentation.fragments.StartFragment
import com.example.whac_a_mole.utils.di.UtilsModule
import dagger.BindsInstance
import dagger.Component

@Component(
    modules = [
        DataModule::class,
        DomainModule::class,
        UtilsModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): ApplicationComponent
    }

    fun inject(resultFragment: ResultFragment)
    fun inject(gameFragment: GameFragment)
    fun inject(startFragment: StartFragment)
}