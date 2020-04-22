package com.aisdev.template.di

import com.aisdev.template.ui.main.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder {

    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): MainFragment
}
