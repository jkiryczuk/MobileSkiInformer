package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;

import jkiryczuk.pl.mobileskiinformer.model.ResortsList;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;

public class NearbyViewModel extends ViewModel {

    public final ObservableField<Boolean> isErrorVisible = new ObservableField<>(false);
    public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);

    private final MutableLiveData<Resource<ResortsList>> resortsData;
    DataRepository repository;
    SharedPrefs sharedPrefsUtils;

    public NearbyViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
        this.resortsData = new MutableLiveData<>();
    }

    public void initializeAllResortsData() {
        setRefreshing(true);
        repository.getResorts(resortsData);
    }

    public MutableLiveData<Resource<ResortsList>> getResortsData() {
        return resortsData;
    }

    public void showError(boolean isVisible) {
        isErrorVisible.set(isVisible);
    }

    public void setRefreshing(boolean isVisible) {
        isRefreshing.set(isVisible);
    }
}
