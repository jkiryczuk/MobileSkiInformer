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
            toggleBottomSheet(resort, adapter);

        });
    }


    public void toggleBottomSheet(NearbyResort response, ListInBottomSheetAdapter adapter) {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            binding.includeBS.setItem(response);
            binding.includeBS.counterSlopes.setText("Ilość stoków: "+String.valueOf(response.getSkiRuns().size()));
            binding.includeBS.callButton.setOnClickListener(view -> {
                makeCall(response);
            });
            binding.includeBS.webButton.setOnClickListener(view -> {
                openSite(response,0);
            });
            binding.includeBS.mapButton.setOnClickListener(view -> {
                openSite(response,1);
            });
            binding.includeBS.navigationButton.setOnClickListener(view -> {
                openMaps(response);
            });
            adapter.setSkiRuns(response.getSkiRuns());
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

    public void makeCall(NearbyResort resort){
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", resort.getPhonenumber(), null));
        context.startActivity(intent);
    }
    public void openSite(NearbyResort resort, int type){
        Intent i = new Intent(Intent.ACTION_VIEW);
        if(type == 0 ){ //is website
            i.setData(Uri.parse(resort.getWebsite()));
        } else if (type == 1) {//is map
            i.setData(Uri.parse(resort.getMapadress()));
        }
        context.startActivity(i);
    }
    public void openMaps(NearbyResort resort){
        Uri gmmIntentUri = Uri.parse("geo:0,0?q="+resort.getLatitude()+","+resort.getLongitude());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
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
