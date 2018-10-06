package jkiryczuk.pl.mobileskiinformer.di;


import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import jkiryczuk.pl.mobileskiinformer.MainActivity;
import jkiryczuk.pl.mobileskiinformer.MainActivityModule;

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();
}
