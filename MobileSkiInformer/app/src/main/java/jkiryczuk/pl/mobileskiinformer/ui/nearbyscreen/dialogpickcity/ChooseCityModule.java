package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.dialogpickcity;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

@Module
public class ChooseCityModule {
    @Provides
    public ChooseCityViewModel provideViewModel(DataRepository repository, SharedPrefs sharedPrefs){
        return new ChooseCityViewModel(repository,sharedPrefs);
    }
}
