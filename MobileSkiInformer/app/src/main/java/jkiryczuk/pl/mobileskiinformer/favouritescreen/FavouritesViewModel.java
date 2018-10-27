package jkiryczuk.pl.mobileskiinformer.favouritescreen;

import android.arch.lifecycle.ViewModel;

import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

public class FavouritesViewModel extends ViewModel {

    private DataRepository repository;
    private SharedPrefs sharedPrefsUtils;

    public FavouritesViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
    }
}
