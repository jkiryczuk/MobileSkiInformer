package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableField;
import android.location.Location;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
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

    public void rewriteList(List<SkiResortResponse> resortsResponseList, List<NearbyResort> resorts){
        for (int i = 0; i < resortsResponseList.size(); i++) {
            resorts.add(new NearbyResort(resortsResponseList.get(i).getId(),
                    resortsResponseList.get(i).getName(),
                    resortsResponseList.get(i).getAddress(),
                    resortsResponseList.get(i).getCity(),
                    resortsResponseList.get(i).getLatitude(),
                    resortsResponseList.get(i).getLongitude(),
                    resortsResponseList.get(i).getBorough(),
                    resortsResponseList.get(i).getPhonenumber(),
                    resortsResponseList.get(i).getWebsite(),
                    resortsResponseList.get(i).getMapadress(),
                    resortsResponseList.get(i).getImage(),
                    0, false, resortsResponseList.get(i).getSkiRuns()));
        }
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

    public float calculateDistance(Location currentLocation,NearbyResort resort) {
        Location destination = new Location("destination");

        destination.setLatitude(resort.getLatitude());
        destination.setLongitude(resort.getLongitude());
        return currentLocation.distanceTo(destination);
    }

}
