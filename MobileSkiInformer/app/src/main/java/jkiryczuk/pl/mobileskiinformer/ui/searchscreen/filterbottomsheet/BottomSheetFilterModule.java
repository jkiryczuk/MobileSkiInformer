package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet;

import dagger.Module;
import dagger.Provides;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;


@Module
public class BottomSheetFilterModule {
    @Provides
    public BottomSheetFilterViewModel provideViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils){
        return new BottomSheetFilterViewModel(repository,sharedPrefsUtils);
    }
}

