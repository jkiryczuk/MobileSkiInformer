package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;

import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

public class NearbyViewModel {

    DataRepository repository;
    SharedPrefs sharedPrefsUtils;

    public NearbyViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
    }
}
