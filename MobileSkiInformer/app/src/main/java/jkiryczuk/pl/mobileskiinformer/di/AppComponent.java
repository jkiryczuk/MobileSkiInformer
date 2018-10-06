package jkiryczuk.pl.mobileskiinformer.di;

import android.app.Application;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import jkiryczuk.pl.mobileskiinformer.SkiInformerApp;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class, AndroidSupportInjectionModule.class,})
public interface AppComponent {

    void inject(SkiInformerApp app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
