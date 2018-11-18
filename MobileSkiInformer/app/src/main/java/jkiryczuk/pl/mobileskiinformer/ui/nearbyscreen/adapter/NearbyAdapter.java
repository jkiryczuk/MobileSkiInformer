package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.adapter;

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
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentNearbyBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.NearbyModelBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.ui.adapter.ListInBottomSheetAdapter;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.NearbyFragment;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder> implements Comparator<NearbyResort> {

    private List<NearbyResort> resorts;
    private Context context;
    private BottomSheetBehavior sheetBehavior;
    private FragmentNearbyBinding binding;
    private List<NearbyResort> favs;


    public NearbyAdapter(List<NearbyResort> resorts, Context context, BottomSheetBehavior sheetBehavior, FragmentNearbyBinding binding) {
        this.resorts = resorts;
        Collections.sort(resorts,this::compare);
        this.context = context;
        this.sheetBehavior = sheetBehavior;
        this.binding = binding;
        favs = ListOfFavourites.getInstance().getResorts();
        notifyDataSetChanged();
    }

    public void setResorts(List<NearbyResort> resorts) {
        this.resorts = resorts;
        Collections.sort(resorts,this::compare);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NearbyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.nearby_model, viewGroup, false);
        return new NearbyAdapter.NearbyViewHolder(view);
    }

    private void deleteFavsItem(long id) {
        for(int i=0;i<favs.size();i++){
            if(favs.get(i).getId() == id){
                favs.remove(i);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyViewHolder nearbyViewHolder, int i) {
        final NearbyResort resort = resorts.get(i);
        nearbyViewHolder.bindData(resort);
        nearbyViewHolder.binding.counterSlopes.setText("Liczba stoków: "+resort.getSkiRuns().size());
        nearbyViewHolder.binding.starN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(resort.isFavourite()) {
                    resort.setFavourite(false);
                    deleteFavsItem(resort.getId());
                    ListOfFavourites.getInstance().serialize(favs);
                    notifyDataSetChanged();
                }
                else {
                    resort.setFavourite(true);
                    favs.add(resort);
                    ListOfFavourites.getInstance().serialize(favs);
                    notifyDataSetChanged();
                }
                notifyDataSetChanged();
            }

        });

        if (nearbyViewHolder.binding != null) {
            StaticMethods.setMiniature(context,resort.getImage(), nearbyViewHolder.binding.miniature);
        }
        nearbyViewHolder.binding.cardNearby.setOnClickListener(view -> {
            ListInBottomSheetAdapter adapter = new ListInBottomSheetAdapter(resort.getSkiRuns(),context);
            binding.includeBS.listinbottomsheet.setAdapter(adapter);
            toggleBottomSheet(resort,adapter);
        });
    }

    public void toggleBottomSheet(NearbyResort response, ListInBottomSheetAdapter adapter) {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            binding.includeBS.nameOfResort.setText(response.getName());
            StaticMethods.setMiniature(context,response.getImage(),binding.includeBS.obrazek);
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

    public void clear() {
        resorts.clear();
        notifyDataSetChanged();
    }

    @Override
    public int compare(NearbyResort resort, NearbyResort t1) {
        if(resort.showDistanceNumbered() > t1.showDistanceNumbered()){
            return 1;
        } else if(resort.showDistanceNumbered() < t1.showDistanceNumbered()) {
            return -1;
        }
        else return 0;
    }

    static public class NearbyViewHolder extends RecyclerView.ViewHolder {

        private final NearbyModelBinding binding;

        public NearbyViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        void bindData(NearbyResort resort) {
            binding.setItem(resort);
        }
    }
}
