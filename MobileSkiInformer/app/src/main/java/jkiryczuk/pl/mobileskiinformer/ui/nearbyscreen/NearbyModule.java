package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

@Module
public class NearbyModule {
    @Provides
    public NearbyViewModel provideNearbyViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        return new NearbyViewModel(repository, sharedPrefsUtils);
    }
}
