package jkiryczuk.pl.mobileskiinformer.di;

import android.app.Application;
import android.content.Context;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.repository.SkiDataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefsUtils;

@Module
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    SharedPrefs provideSharedPreferences(SharedPrefsUtils sharedPrefsUtils) {
        return sharedPrefsUtils;
    }

    @Provides
    @Singleton
    DataRepository provideRepository(SkiDataRepository repository) {
        return repository;
    }
}
