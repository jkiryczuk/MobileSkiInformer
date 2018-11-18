package jkiryczuk.pl.mobileskiinformer.ui.favouritescreen;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.AndroidSupportInjection;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FavouritesFragmentBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.ui.favouritescreen.adapter.FavsListAdapter;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.NearbyFragment;

public class FavouritesFragment extends Fragment {

    @Inject
    FavouritesViewModel viewModel;
    private List<NearbyResort> favsList;
    private FavsListAdapter adapter;
    private FavouritesFragmentBinding binding;
    BottomSheetBehavior sheetBehavior;
    LinearLayout layout;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        AndroidSupportInjection.inject(this);
        binding = FavouritesFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        layout = binding.includeBS.bottomSheet;
        sheetBehavior = BottomSheetBehavior.from(layout);
        favsList = ListOfFavourites.getInstance().getResorts();
        setVisibleObjects();
        adapter = new FavsListAdapter(favsList,getContext(),sheetBehavior,binding);
        binding.favsrecycler.setAdapter(adapter);
        return binding.getRoot();
    }

    public void setVisibleObjects() {
        if (favsList.size() == 0) {
            binding.promptNoFavs.setVisibility(View.VISIBLE);
            binding.llwrecycler.setVisibility(View.GONE);
        } else {
            binding.promptNoFavs.setVisibility(View.GONE);
            binding.llwrecycler.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        adapter.notifyDataSetChanged();
    }
}
