package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import jkiryczuk.pl.mobileskiinformer.model.ResortsList;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.CountyResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;
import lombok.Getter;

public class BottomSheetFilterViewModel {

    public final ObservableField<Boolean> isErrorVisible = new ObservableField<>(false);
    public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);
    @Getter
    private final MutableLiveData<Resource<VoivodeshipResponse>> voivodeshipData;
    @Getter
    private final MutableLiveData<Resource<CountyResponse>> countyData;
    @Getter
    private final MutableLiveData<Resource<BoroughResponse>> boroughData;
    @Getter
    private final MutableLiveData<Resource<ResortsList>> resortsData;

    DataRepository repository;
    SharedPrefs sharedPrefsUtils;

    public BottomSheetFilterViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
        this.repository = repository;
        this.sharedPrefsUtils = sharedPrefsUtils;
        this.voivodeshipData = new MutableLiveData<>();
        this.countyData = new MutableLiveData<>();
        this.boroughData = new MutableLiveData<>();
        this.resortsData = new MutableLiveData<>();
    }

    public void initializeVoivodeships(){
        setRefreshing(true);
        //TODO repository method
    }

    public void showError(boolean isVisible) {
        isErrorVisible.set(isVisible);
    }

    public void setRefreshing(boolean isVisible) {
        isRefreshing.set(isVisible);
    }
}
