package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet;

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

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FilterbottomsheetBinding;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;

public class BottomSheetFilterFragment extends BottomSheetDialogFragment implements AdapterView.OnItemSelectedListener {

    @Inject
    BottomSheetFilterViewModel viewModel;
    List<NearbyResort> resorts = new ArrayList<>();
    Spinner boroughSpinner;
    Spinner countySpinner;
    Spinner voivodeshipSpinner;

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
        FilterbottomsheetBinding binding = FilterbottomsheetBinding.inflate(inflater, container, false);

        boroughSpinner = binding.boroughSpinner;
        countySpinner = binding.countySpinner;
        voivodeshipSpinner = binding.voivodeshipSpinner;

        // Spinner click listener
        boroughSpinner.setOnItemSelectedListener(this);
        countySpinner.setOnItemSelectedListener(this);
        voivodeshipSpinner.setOnItemSelectedListener(this);

        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        boroughSpinner.setAdapter(dataAdapter);

        return binding.getRoot();
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.voivodeship_spinner:
                break;
            case R.id.county_spinner:
                break;
            case R.id.borough_spinner:
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
