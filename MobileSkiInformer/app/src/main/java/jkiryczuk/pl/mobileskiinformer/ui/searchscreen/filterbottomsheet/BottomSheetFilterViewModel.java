package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.BoroughsList;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.CountiesList;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.ResortsList;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.CountyResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.VoivodeshipsList;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;
import lombok.Getter;

public class BottomSheetFilterViewModel {

    public final ObservableField<Boolean> isErrorVisible = new ObservableField<>(false);
    public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);
    private final MutableLiveData<Resource<VoivodeshipsList>> voivodeshipData;
    @Getter
    private final MutableLiveData<Resource<CountiesList>> countyData;
    @Getter
    private final MutableLiveData<Resource<BoroughsList>> boroughData;
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
        repository.getVoivodeships(voivodeshipData);
    }

    public void fetchCounties(Long id){
        setRefreshing(true);
        repository.getCountiesInVoivodeShip(id,countyData);
    }
    public void fetchBoroughs(Long id){
        setRefreshing(true);
        repository.getBoroughsInCounties(id, boroughData);
    }
    public void convertList(List<NearbyResort> resorts2, List<SkiResortResponse> resortsResponseList) {
        for (SkiResortResponse response : resortsResponseList) {
            resorts2.add(new NearbyResort(response));
        }
    }

    public void showError(boolean isVisible) {
        isErrorVisible.set(isVisible);
    }

    public void setRefreshing(boolean isVisible) {
        isRefreshing.set(isVisible);
    }

    public MutableLiveData<Resource<VoivodeshipsList>> getVoivodeshipData() {
        return voivodeshipData;
    }

    public void getResortsByVoivodeships(Long id) {
        repository.getResortsInVoivodeship(id,resortsData);
    }

    public void getResortsByCounty(Long id) {
        repository.getResortsInCounty(id,resortsData);
    }

    public void getResortsByBorough(Long id) {
        repository.getResortsInBorough(id,resortsData);
    }
}
