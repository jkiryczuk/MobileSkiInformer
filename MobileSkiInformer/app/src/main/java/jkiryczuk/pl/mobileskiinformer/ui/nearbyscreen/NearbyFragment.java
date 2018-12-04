package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.BuildConfig;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentNearbyBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.ui.mainactivity.MainActivity;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.adapter.NearbyAdapter;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class NearbyFragment extends Fragment {

    private static final String TAG = NearbyFragment.class.getSimpleName();
    private final List<NearbyResort> resorts = new ArrayList<>();
    @Inject
    NearbyViewModel viewModel;
    private NearbyAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<NearbyResort> favsResort;
    private static final int REQUEST_PERMISSIONS_REQUEST_CODE = 34;
    private FusedLocationProviderClient mFusedLocationClient;
    protected Location mLastLocation;
    private BottomSheetBehavior sheetBehavior;
    private LinearLayout layout;
    private FragmentNearbyBinding binding;

    @Override
    public void onResume() {
        adapter.clear();
        getLastLocation();
        super.onResume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        binding = FragmentNearbyBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this.getActivity());
        if (!checkPermissions()) {
            requestPermissions();
        } else {
            getLastLocation();
        }
        binding.fab.setOnClickListener(view -> {
            NewTaskDialogFragment dialog = new NewTaskDialogFragment();
            dialog.show(getFragmentManager(),"TAG");

        });
        layout = binding.includeBS.bottomSheet;
        sheetBehavior = BottomSheetBehavior.from(layout);
        swipeRefreshLayout = binding.swipeNearbyResortsContainer;
        adapter = new NearbyAdapter(resorts, getContext(), sheetBehavior, binding);
        binding.nearbyResortsList.setAdapter(adapter);
        subscribeUi();
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        setupSwipeLayoutListener();
        favsResort = ListOfFavourites.getInstance().getResorts();
        viewModel.setRefreshing(true);
        viewModel.initializeAllResortsData();
        setSheetBehaviourCallback();
        return binding.getRoot();
    }

    private void subscribeUi() {
        observeGetResortsResult();
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

    private void observeGetResortsResult() {
        viewModel.getResortsData().observe(this, resource -> {
            if (resource == null
                    || resource.getData() == null
                    || resource.getStatus() != Resource.Status.SUCCESS) {
                viewModel.showError(true);
                viewModel.setRefreshing(false);
                return;
            }
            adapter.clear();
            List<SkiResortResponse> resortsResponseList = resource.getData().getResortsList();
            viewModel.rewriteList(resortsResponseList, resorts);
            if (mLastLocation != null) {
                calculateNearest(resortsResponseList);
            }
            StaticMethods.filterList(resorts, favsResort);
            adapter.setResorts(resorts);
            viewModel.showError(false);
            viewModel.setRefreshing(false);
        });
    }

    private void calculateNearest(List<SkiResortResponse> resortsResponseList) {
        for (int i = 0; i < resortsResponseList.size(); i++) {
            resorts.get(i).setDistance(viewModel.calculateDistance(mLastLocation, resorts.get(i)) / 1000);
        }
    }

    private void setupSwipeLayoutListener() {
        swipeRefreshLayout.setOnRefreshListener(() -> {
            Log.e(TAG, "REFRESHING");
            adapter.clear();
            if (mLastLocation != null) {
                getLastLocation();
                viewModel.initializeAllResortsData();
            }
        });
    }


    @SuppressWarnings("MissingPermission")
    private void getLastLocation() {
        if (checkPermissions()) {
            mFusedLocationClient.getLastLocation()
                    .addOnCompleteListener(this.getActivity(), task -> {
                        if (task.getResult() == null) {
                            viewModel.showError(true);
                            viewModel.setRefreshing(true);
                            binding.nearbyResortsList.setVisibility(View.GONE);
                            Log.e(TAG, "TASK IS NULL ");
                        }
                        if (task.isSuccessful() && task.getResult() != null) {
                            Log.e(TAG, "SUCCESS");
                            viewModel.setRefreshing(false);
                            viewModel.showError(false);
                            mLastLocation = task.getResult();
                            adapter.clear();
                            viewModel.initializeAllResortsData();

                        } else {
                            Log.w(TAG, "getLastLocation:exception", task.getException());
                            viewModel.setRefreshing(false);
                            viewModel.showError(true);
                            showSnackbar(getString(R.string.no_location_detected));
                        }
                    });
        } else {
            viewModel.showError(true);
        }

    }

    private void showSnackbar(final String text) {
        View container = getView().findViewById(R.id.main_activity_container);
        if (container != null) {
            Snackbar.make(container, text, Snackbar.LENGTH_LONG).show();
        }
    }

    private void showSnackbar(final int mainTextStringId, final int actionStringId,
                              View.OnClickListener listener) {
        Snackbar.make(getActivity().findViewById(android.R.id.content),
                getString(mainTextStringId),
                Snackbar.LENGTH_INDEFINITE)
                .setAction(getString(actionStringId), listener).show();
    }

    private boolean checkPermissions() {
        int permissionState = ActivityCompat.checkSelfPermission(this.getActivity(),
                Manifest.permission.ACCESS_COARSE_LOCATION);
        return permissionState == PackageManager.PERMISSION_GRANTED;
    }

    private void startLocationPermissionRequest() {
        ActivityCompat.requestPermissions(this.getActivity(),
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                REQUEST_PERMISSIONS_REQUEST_CODE);
    }

    private void requestPermissions() {
        boolean shouldProvideRationale =
                ActivityCompat.shouldShowRequestPermissionRationale(this.getActivity(),
                        Manifest.permission.ACCESS_COARSE_LOCATION);

        if (shouldProvideRationale) {
            Log.i(TAG, "Displaying permission rationale to provide additional context.");

            showSnackbar(R.string.permission_rationale, android.R.string.ok,
                    view -> {
                        // Request permission
                        startLocationPermissionRequest();
                    });

        } else {
            Log.i(TAG, "Requesting permission");
            startLocationPermissionRequest();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        Log.i(TAG, "onRequestPermissionResult");
        if (requestCode == REQUEST_PERMISSIONS_REQUEST_CODE) {
            Log.i(TAG, "User interaction was cancelled.");
        } else if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                 Permission granted.
            getLastLocation();
        } else {
            Log.e(TAG, "User denied");
            showSnackbar(R.string.permission_denied_explanation, R.string.settings,
                    view -> {
                        // Build intent that displays the App settings screen.
                        Intent intent = new Intent();
                        intent.setAction(
                                Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                        Uri uri = Uri.fromParts("package",
                                BuildConfig.APPLICATION_ID, null);
                        intent.setData(uri);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                    });
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        viewModel.initializeAllResortsData();

    }
}

