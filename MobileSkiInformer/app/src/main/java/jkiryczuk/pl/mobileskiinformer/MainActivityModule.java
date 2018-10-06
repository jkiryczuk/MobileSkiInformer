package jkiryczuk.pl.mobileskiinformer;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

@Module
public class MainActivityModule {
    @Provides
    public MainActivityViewModel provideProfileViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        return new MainActivityViewModel(repository, sharedPrefsUtils);
    }
}
