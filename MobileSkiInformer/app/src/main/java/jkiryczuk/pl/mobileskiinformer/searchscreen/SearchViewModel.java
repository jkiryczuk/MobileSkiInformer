package jkiryczuk.pl.mobileskiinformer.searchscreen;

import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

public class SearchViewModel {

    DataRepository repository;
    SharedPrefs sharedPrefsUtils;

    public SearchViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
    }
}
