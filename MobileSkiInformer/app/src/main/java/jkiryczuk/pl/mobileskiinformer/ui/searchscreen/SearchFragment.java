package jkiryczuk.pl.mobileskiinformer.ui.searchscreen;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.adapter.NearbyAdapter;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.adapter.SearchFragmentAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {

    @Inject
    SearchViewModel viewModel;
    private SearchFragmentAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private final List<SkiResortResponse> resorts = new ArrayList<>();
    BottomSheetBehavior sheetBehavior;
    LinearLayout layout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        FragmentSearchBinding binding = FragmentSearchBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        layout = binding.includeBS.bottomSheet;
        sheetBehavior = BottomSheetBehavior.from(layout);
        swipeRefreshLayout = binding.swipeNearbyResortsContainer;
        adapter = new SearchFragmentAdapter(resorts, getContext());
        binding.resortsList.setAdapter(adapter);
        subscribeUi();
        setupSwipeLayoutListener();

        viewModel.setRefreshing(true);
        viewModel.initializeAllResortsData();

//        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(@NonNull View bottomSheet, int newState) {
//                switch (newState) {
//                    case BottomSheetBehavior.STATE_HIDDEN:
//                        break;
//                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        btnBottomSheet.setText("Close Sheet");
//                    }
//                    break;
//                    case BottomSheetBehavior.STATE_COLLAPSED: {
//                        btnBottomSheet.setText("Expand Sheet");
//                    }
//                    break;
//                    case BottomSheetBehavior.STATE_DRAGGING:
//                        break;
//                    case BottomSheetBehavior.STATE_SETTLING:
//                        break;
//                }
//            }
//
//            @Override
//            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
//
//            }
//        });
        return binding.getRoot();

    }

    private void setupSwipeLayoutListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
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
           adapter.setResorts(resortsResponseList);
            viewModel.showError(false);
            viewModel.setRefreshing(false);
        });
    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//            btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//            btnBottomSheet.setText("Expand sheet");
        }
    }

}
