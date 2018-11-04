package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentNearbyBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.adapter.NearbyAdapter;

public class NearbyFragment extends Fragment {

    private final List<NearbyResort> resorts = new ArrayList<>();
    @Inject
    NearbyViewModel viewModel;
    private NearbyAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<NearbyResort> favsResort;
    @Override
    public void onResume() {
        adapter.clear();
        viewModel.initializeAllResortsData();
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        FragmentNearbyBinding binding = FragmentNearbyBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        swipeRefreshLayout = binding.swipeNearbyResortsContainer;
        adapter = new NearbyAdapter(resorts, getContext());
        binding.nearbyResortsList.setAdapter(adapter);
        subscribeUi();
        setupSwipeLayoutListener();

        viewModel.setRefreshing(true);
        viewModel.initializeAllResortsData();
        //TODO: w inne miejsce z logiką
        favsResort = ListOfFavourites.getInstance().getResorts();
        return binding.getRoot();
    }

    private void subscribeUi() {
        observeGetResortsResult();
    }

    private void observeGetResortsResult() {
        viewModel.getResortsData().observe(this, resource -> {
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            List<SkiResortResponse> resortsResponseList = resource.getData().getResortsList();
            calculateNearest(resortsResponseList);
            adapter.setResorts(resorts);
            viewModel.showError(false);
            viewModel.setRefreshing(false);
        });
    }

    private void calculateNearest(List<SkiResortResponse> resortsResponseList) {
        for (int i = 0; i < resortsResponseList.size(); i++) {
            resorts.add(new NearbyResort(resortsResponseList.get(i).getId(),
                    resortsResponseList.get(i).getName(),
                    resortsResponseList.get(i).getAddress(),
                    resortsResponseList.get(i).getCity(),
                    resortsResponseList.get(i).getLatitude(),
                    resortsResponseList.get(i).getLongitude(),
                    resortsResponseList.get(i).getBorough(),
                    100, false));
        }
    }

    private void setupSwipeLayoutListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            adapter.clear();
            viewModel.initializeAllResortsData();
        });
    }

}
