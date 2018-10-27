package jkiryczuk.pl.mobileskiinformer.ui.favouritescreen;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

@Module
public class FavouritesModule {
    @Provides
    public FavouritesViewModel provideFavouritesViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils){
        return new FavouritesViewModel(repository,sharedPrefsUtils);
    }
}
