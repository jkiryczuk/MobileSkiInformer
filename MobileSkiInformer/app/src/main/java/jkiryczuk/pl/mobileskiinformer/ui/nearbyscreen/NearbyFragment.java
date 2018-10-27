package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentNearbyBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class NearbyFragment extends Fragment {

    @Inject
    NearbyViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        FragmentNearbyBinding binding = FragmentNearbyBinding.inflate(inflater,container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();
    }

}
