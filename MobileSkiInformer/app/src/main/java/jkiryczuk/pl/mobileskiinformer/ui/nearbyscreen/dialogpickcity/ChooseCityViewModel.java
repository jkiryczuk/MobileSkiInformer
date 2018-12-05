package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.dialogpickcity;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.CitiesList;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.ResortsList;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;
import lombok.Getter;

public class ChooseCityViewModel {

    public final ObservableField<Boolean> isErrorVisible = new ObservableField<>(false);
    public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);

    @Getter
    private final MutableLiveData<Resource<CitiesList>> citiesData;

    DataRepository repository;
    SharedPrefs sharedPrefsUtils;

    public ChooseCityViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
        this.citiesData = new MutableLiveData<>();
    }

    public void fetchData(){
        setRefreshing(true);
        repository.getCities(citiesData);
    }

    public ObservableField<Boolean> getIsErrorVisible() {
        return isErrorVisible;
    }

    public ObservableField<Boolean> getIsRefreshing() {
        return isRefreshing;
    }

    public void showError(boolean isVisible) {
        isErrorVisible.set(isVisible);
    }

    public void setRefreshing(boolean isVisible) {
        isRefreshing.set(isVisible);
    }
}
