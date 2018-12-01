package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FilterbottomsheetBinding;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.CountyResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.BoroughsList;
import jkiryczuk.pl.mobileskiinformer.model.response.lists.VoivodeshipsList;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class BottomSheetFilterFragment extends BottomSheetDialogFragment implements AdapterView.OnItemSelectedListener {

    @Inject
    BottomSheetFilterViewModel viewModel;
    List<NearbyResort> resorts = new ArrayList<>();
    List<VoivodeshipResponse> voivodeships = new ArrayList<>();
    List<CountyResponse> counties = new ArrayList<>();
    List<BoroughResponse> boroughs = new ArrayList<>();
    Spinner boroughSpinner;
    Spinner countySpinner;
    Spinner voivodeshipSpinner;
    ArrayAdapter<VoivodeshipResponse> voivodeshipsAdapter;
    ArrayAdapter<CountyResponse> countyAdapter;
    ArrayAdapter<BoroughResponse> boroughAdapter;

    public BottomSheetFilterFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        FilterbottomsheetBinding binding = FilterbottomsheetBinding.inflate(inflater, container, false);
        boroughSpinner = binding.boroughSpinner;
        countySpinner = binding.countySpinner;
        voivodeshipSpinner = binding.voivodeshipSpinner;
//        setupSpinners(boroughSpinner, countySpinner, voivodeshipSpinner);
        boroughSpinner.setVisibility(View.GONE);
        countySpinner.setVisibility(View.GONE);
        viewModel.setRefreshing(true);
        subscribeUi();
        viewModel.initializeVoivodeships();

        return binding.getRoot();
    }

    private void subscribeUi() {
        observeGetVoivoideshipResult();
        observeGetCountiesResult();
    }

    private void observeGetCountiesResult() {
        viewModel.getCountyData().observe(this, resource -> {
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            counties = resource.getData().getCountiesList();
            viewModel.showError(false);
            viewModel.setRefreshing(false);
            countySpinner.setVisibility(View.VISIBLE);
            countySpinner.setOnItemSelectedListener(this);
            countyAdapter = new ArrayAdapter<CountyResponse>(this.getContext(), android.R.layout.simple_spinner_item, counties);
            countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            countySpinner.setAdapter(countyAdapter);
        });
    }

    private void observeGetVoivoideshipResult() {
        viewModel.getVoivodeshipData().observe(this, resource -> {
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            voivodeships = resource.getData().getVoivodeshipsList();
            viewModel.showError(false);
            viewModel.setRefreshing(false);
            voivodeshipSpinner.setOnItemSelectedListener(this);
            voivodeshipsAdapter = new ArrayAdapter<VoivodeshipResponse>(this.getContext(), android.R.layout.simple_spinner_item, voivodeships);
            voivodeshipsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            voivodeshipSpinner.setAdapter(voivodeshipsAdapter);
        });
    }


    private void setupSpinners(Spinner boroughSpinner, Spinner countySpinner, Spinner voivodeshipSpinner) {
        // Spinner click listener
        boroughSpinner.setOnItemSelectedListener(this);
        countySpinner.setOnItemSelectedListener(this);
        voivodeshipSpinner.setOnItemSelectedListener(this);

        // Creating adapter for spinner
        voivodeshipsAdapter = new ArrayAdapter<VoivodeshipResponse>(this.getContext(), android.R.layout.simple_spinner_item, voivodeships);
        countyAdapter = new ArrayAdapter<CountyResponse>(this.getContext(), android.R.layout.simple_spinner_item, counties);
        boroughAdapter = new ArrayAdapter<BoroughResponse>(this.getContext(), android.R.layout.simple_spinner_item, boroughs);
        // Drop down layout style - list view with radio button
        voivodeshipsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        boroughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        voivodeshipSpinner.setAdapter(voivodeshipsAdapter);
        countySpinner.setAdapter(countyAdapter);
        boroughSpinner.setAdapter(boroughAdapter);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.voivodeship_spinner:
                VoivodeshipResponse item = voivodeshipsAdapter.getItem(i);
                viewModel.fetchCounties(item.getId());
                break;
            case R.id.county_spinner:
                CountyResponse county = countyAdapter.getItem(i);
                viewModel.fetchBoroughs(county.getId());
                break;
            case R.id.borough_spinner:
                BoroughResponse borough  = boroughAdapter.getItem(i);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
