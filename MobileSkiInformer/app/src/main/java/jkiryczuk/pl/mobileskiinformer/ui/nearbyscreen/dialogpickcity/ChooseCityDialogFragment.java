package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.dialogpickcity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.DialogChooseCityNearbyFragmentBinding;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.CityResponse;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.Connector;


@SuppressLint("ValidFragment")
public class ChooseCityDialogFragment extends DialogFragment implements
        android.view.View.OnClickListener {

    @Inject
    ChooseCityViewModel viewModel;
    private final Connector callback;
    DialogChooseCityNearbyFragmentBinding binding;
    List<CityResponse> cities = new ArrayList<>();
    Spinner citiesSpinner;
    ArrayAdapter<CityResponse> citiesAdapter;
    private CityResponse response;
    private AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            response = citiesAdapter.getItem(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @SuppressLint("ValidFragment")
    public ChooseCityDialogFragment(Connector callback) {
        this.callback = callback;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AndroidSupportInjection.inject(this);
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()),
                R.layout.dialog_choose_city_nearby_fragment, null,false);
        View dialog = binding.csd;
        builder.setView(dialog);
        citiesSpinner = binding.citiesSpinner;
        binding.dialogButtonOK.setOnClickListener(view -> {
            //            Snackbar.make(getActivity().findViewById(android.R.id.content),
//                    "Look at me, I'm a fancy snackbar", Snackbar.LENGTH_LONG).show();
            callback.callbackId(response.getId(),response.getLng(),response.getLat());
        });
        observeResult();
        viewModel.fetchData();
        return builder.create();
    }

    private void observeResult() {
        viewModel.getCitiesData().observe(this, resource ->{
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            cities = resource.getData().getCities();
            setupSpinner();
            viewModel.showError(false);
            viewModel.setRefreshing(false);
        } );
    }

    private void setupSpinner() {
        citiesSpinner.setOnItemSelectedListener(listener);
        citiesAdapter = new ArrayAdapter<CityResponse>(this.getContext(), android.R.layout.simple_spinner_item, cities);
        citiesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        citiesSpinner.setAdapter(citiesAdapter);
    }


    @Override
    public void onClick(View view) {

    }
}