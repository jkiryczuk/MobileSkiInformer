package jkiryczuk.pl.mobileskiinformer.ui.favouritescreen.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FavouritesFragmentBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.SearchItemBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.ui.adapter.ListInBottomSheetAdapter;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class FavsListAdapter extends RecyclerView.Adapter<FavsListAdapter.FavsViewHolder> {

    private List<NearbyResort> resorts;
    private Context context;
    private BottomSheetBehavior sheetBehavior;
    private FavouritesFragmentBinding binding;

    public FavsListAdapter(List<NearbyResort> resorts, Context context, BottomSheetBehavior sheetBehavior, FavouritesFragmentBinding binding) {
        this.resorts = resorts;
        this.context = context;
        this.sheetBehavior = sheetBehavior;
        this.binding = binding;
    }

    @NonNull
    @Override
    public FavsViewHolder onCreateViewHolder(@android.support.annotation.NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_item, viewGroup, false);
        return new FavsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@android.support.annotation.NonNull FavsViewHolder favsViewHolder, int i) {
        final NearbyResort resort = resorts.get(i);
        favsViewHolder.bindData(resort);
        favsViewHolder.binding.counterSlopes.setText("Liczba stoków: " + resort.getSkiRuns().size());
        favsViewHolder.binding.starS.setOnClickListener(view -> {
            resort.setFavourite(false);
            resorts.remove(i);
            ListOfFavourites.getInstance().serialize(resorts);
            if (resorts.size() == 0) {
                binding.promptNoFavs.setVisibility(View.VISIBLE);
                binding.llwrecycler.setVisibility(View.GONE);
            }
            notifyDataSetChanged();
        });
        if (favsViewHolder.binding != null) {
            StaticMethods.setMiniature(context, resort.getImage(), favsViewHolder.binding.miniature);
        }
        favsViewHolder.binding.cardNearby.setOnClickListener(v -> {
            ListInBottomSheetAdapter adapter = new ListInBottomSheetAdapter(resort.getSkiRuns(), context);
            binding.includeBS.listinbottomsheet.setAdapter(adapter);
            binding.includeBS.setItem(resort);
            TextView counterSlopes = binding.includeBS.counterSlopes;
            ImageButton callButton = binding.includeBS.callButton;
            ImageButton webButton = binding.includeBS.webButton;
            ImageButton mapButton = binding.includeBS.mapButton;
            ImageButton navigationButton = binding.includeBS.navigationButton;
            StaticMethods.toggleBottomSheet(resort, adapter, sheetBehavior, context,counterSlopes,callButton,webButton,mapButton,navigationButton);

        });
    }






    @Override
    public int getItemCount() {
        return resorts.size();
    }

    static public class FavsViewHolder extends RecyclerView.ViewHolder {

        private final SearchItemBinding binding;

        public FavsViewHolder(@android.support.annotation.NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        void bindData(NearbyResort resort) {
            binding.setItem(resort);
        }
    }
}
