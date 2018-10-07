package jkiryczuk.pl.mobileskiinformer;

import android.arch.lifecycle.MutableLiveData;

import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

public class MainActivityViewModel {

    private DataRepository repository;
    private SharedPrefs sharedPrefsUtils;
    private BoroughResponse boroughResponse;
    private final MutableLiveData<Resource<BoroughResponse>> serverResponse;

    public MainActivityViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
        serverResponse = new MutableLiveData<>();
        boroughResponse = new BoroughResponse();
    }

    public void fetchTestData(){
        repository.getBorough((long) 1, serverResponse);
    }

    public MutableLiveData<Resource<BoroughResponse>> getServerResponse() {
        return serverResponse;
    }

    public BoroughResponse getBoroughResponse() {
        return boroughResponse;
    }

    public void setBoroughResponse(BoroughResponse boroughResponse) {
        this.boroughResponse = boroughResponse;
    }
}
