package jkiryczuk.pl.mobileskiinformer.ui.searchscreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.adapter.SearchFragmentAdapter;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.filterbottomsheet.BottomSheetFilterFragment;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class SearchFragment extends Fragment {

    @Inject
    SearchViewModel viewModel;
    private SearchFragmentAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private  List<NearbyResort> favs;
    private final List<NearbyResort> resorts2 = new ArrayList<>();
    private BottomSheetBehavior sheetBehavior;
    private LinearLayout layout;
    private EditText searchInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        FragmentSearchBinding binding = FragmentSearchBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        layout = binding.includeBS.bottomSheet;
        sheetBehavior = BottomSheetBehavior.from(layout);
        swipeRefreshLayout = binding.swipeNearbyResortsContainer;
        searchInput = binding.search;
        adapter = new SearchFragmentAdapter(resorts2, getContext(), sheetBehavior, binding);
        binding.filterBut.setOnClickListener(view -> {
            BottomSheetFilterFragment bottomSheetFilterFragment = new BottomSheetFilterFragment();
            bottomSheetFilterFragment.show(getFragmentManager(), bottomSheetFilterFragment.getTag());
        });
        binding.resortsList.setAdapter(adapter);
        viewModel.addTextListener(searchInput,adapter,resorts2);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        subscribeUi();
        setupSwipeLayoutListener();
        favs = ListOfFavourites.getInstance().getResorts();
        viewModel.setRefreshing(true);
        viewModel.initializeAllResortsData();
        setSheetBehaviourCallback();
        return binding.getRoot();

    }

    private void setSheetBehaviourCallback() {
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }



    private void setupSwipeLayoutListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            resorts2.clear();
            adapter.clear();
            viewModel.initializeAllResortsData();
        });
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
            viewModel.convertList(resorts2, resortsResponseList);
            StaticMethods.filterList(resorts2, favs);
            adapter.setResorts(resorts2);
            viewModel.showError(false);
            viewModel.setRefreshing(false);
        });
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        adapter.clear();
        viewModel.initializeAllResortsData();
    }
}
