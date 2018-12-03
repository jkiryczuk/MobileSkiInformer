package jkiryczuk.pl.mobileskiinformer.ui.searchscreen;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.ResortsList;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.repository.DataRepository;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.adapter.SearchFragmentAdapter;
import jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils.SharedPrefs;
import lombok.Setter;

public class SearchViewModel {

    public final ObservableField<Boolean> isErrorVisible = new ObservableField<>(false);
    public final ObservableField<Boolean> isRefreshing = new ObservableField<>(false);
    private final MutableLiveData<Resource<ResortsList>> resortsData;

    DataRepository repository;
    SharedPrefs sharedPrefsUtils;

    public SearchViewModel(DataRepository repository, SharedPrefs sharedPrefsUtils) {
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

    public void convertList(List<NearbyResort> resorts2, List<SkiResortResponse> resortsResponseList) {
        for (SkiResortResponse response : resortsResponseList) {
            resorts2.add(new NearbyResort(response));
        }
    }

    public void addTextListener(EditText searchInput, SearchFragmentAdapter adapter, List<NearbyResort> resorts2) {
        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                charSequence = charSequence.toString().toLowerCase();

                final List<NearbyResort> filteredList = new ArrayList<>();

                for (int x = 0; x < resorts2.size(); x++) {

                    final String text = resorts2.get(x).getName().toLowerCase();
                    if (text.contains(charSequence)) {

                        filteredList.add(resorts2.get(x));
                    }
                }
                adapter.setResorts(filteredList);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }
}
