package jkiryczuk.pl.mobileskiinformer.searchscreen;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.favouritescreen.FavouritesViewModel;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;


@Module
public class SearchModule {
    @Provides
    public SearchViewModel provideSearchViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils){
        return new SearchViewModel(repository,sharedPrefsUtils);
    }
}
