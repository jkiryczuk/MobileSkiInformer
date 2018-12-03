package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import jkiryczuk.pl.mobileskiinformer.Constants;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FilterbottomsheetBinding;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.CountyResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.SearchFragment;

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
    Spinner levelSpinner;
    ArrayAdapter<VoivodeshipResponse> voivodeshipsAdapter;
    ArrayAdapter<CountyResponse> countyAdapter;
    ArrayAdapter<BoroughResponse> boroughAdapter;
    ArrayAdapter<String> levelAdapter;
    FilterbottomsheetBinding binding;

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
        binding = FilterbottomsheetBinding.inflate(inflater, container, false);
        boroughSpinner = binding.boroughSpinner;
        countySpinner = binding.countySpinner;
        voivodeshipSpinner = binding.voivodeshipSpinner;
        levelSpinner = binding.levelSpinner;

        boroughSpinner.setVisibility(View.GONE);
        countySpinner.setVisibility(View.GONE);
        levelSpinner.setOnItemSelectedListener(this);
        List<String> levels = new ArrayList<String>();
        levels.add(Constants.VOIVODESHIPS);
        levels.add(Constants.COUNTIES);
        levels.add(Constants.BOROUGHS);
        levelAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, levels);
        levelAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        levelSpinner.setAdapter(levelAdapter);
        viewModel.setRefreshing(true);
        subscribeUi();
        viewModel.initializeVoivodeships();
        return binding.getRoot();
    }

    private void subscribeUi() {
        observeGetVoivoideshipResult();
        observeGetCountiesResult();
        observerBoroughResult();
        observerGetSkiResortsResult();
    }

    private void observerBoroughResult() {
        viewModel.getBoroughData().observe(this, resource -> {
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            boroughs = resource.getData().getBoroughsList();
            viewModel.showError(false);
            viewModel.setRefreshing(false);
            boroughSpinner.setVisibility(View.VISIBLE);
            boroughSpinner.setOnItemSelectedListener(this);
            boroughAdapter = new ArrayAdapter<BoroughResponse>(this.getContext(), android.R.layout.simple_spinner_item, boroughs);
            boroughAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            boroughSpinner.setAdapter(boroughAdapter);
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

    private void observerGetSkiResortsResult() {
        viewModel.getResortsData().observe(this, resource -> {
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            //todo set for searchfragment
        });
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

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//        String level = levelAdapter.getItem(i);
        String level = (String) levelSpinner.getSelectedItem();
        switch (adapterView.getId()) {
            case R.id.level_spinner:
                switch (level) {
                    case Constants.VOIVODESHIPS:
                        voivodeshipSpinner.setVisibility(View.VISIBLE);
                        goneItems(countySpinner, binding.textCounty, binding.lineCounty);
                        goneItems(boroughSpinner, binding.textBorough, binding.lineBorough);

                        break;
                    case Constants.COUNTIES:
                        voivodeshipSpinner.setVisibility(View.VISIBLE);
                        makeVisible(countySpinner, binding.lineCounty, binding.textCounty);
                        goneItems(boroughSpinner, binding.textBorough, binding.lineBorough);
                        break;
                    case Constants.BOROUGHS:
                        voivodeshipSpinner.setVisibility(View.VISIBLE);
                        makeVisible(countySpinner, binding.lineCounty, binding.textCounty);
                        makeVisible(boroughSpinner, binding.textBorough, binding.lineBorough);
                        break;

                }
                break;
            case R.id.voivodeship_spinner:
                if (!level.equals(Constants.VOIVODESHIPS)) {
                    VoivodeshipResponse item = voivodeshipsAdapter.getItem(i);
                    viewModel.fetchCounties(item.getId());
                } else {
                    //TODO fetch all from voivodeship
                }
                break;
            case R.id.county_spinner:
                if (level.equals(Constants.BOROUGHS)) {
                    CountyResponse county = countyAdapter.getItem(i);
                    viewModel.fetchBoroughs(county.getId());
                } else if (levelAdapter.getItem(i).equals(Constants.COUNTIES)) {
                    //TODO Fetch resorts from server in county
                }
                break;
            case R.id.borough_spinner:
                if (level.equals(Constants.BOROUGHS)) {
                    BoroughResponse borough = boroughAdapter.getItem(i);

                }
                break;
            default:
                break;
        }
    }

    private void makeVisible(Spinner spinner, View line, View text) {
        spinner.setVisibility(View.VISIBLE);
        line.setVisibility(View.VISIBLE);
        text.setVisibility(View.VISIBLE);
    }

    private void goneItems(Spinner spinner, View text, View line) {
        spinner.setVisibility(View.GONE);
        text.setVisibility(View.GONE);
        line.setVisibility(View.GONE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
