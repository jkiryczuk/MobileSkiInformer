package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
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
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.ui.adapter.ListInBottomSheetAdapter;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.NearbyFragment;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder> implements Comparator<NearbyResort> {

    private List<NearbyResort> resorts;
    private Context context;
    private BottomSheetBehavior sheetBehavior;
    private FragmentNearbyBinding binding;


    public NearbyAdapter(List<NearbyResort> resorts, Context context, BottomSheetBehavior sheetBehavior, FragmentNearbyBinding binding) {
        this.resorts = resorts;
        Collections.sort(resorts,this::compare);
        this.context = context;
        this.sheetBehavior = sheetBehavior;
        this.binding = binding;
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

    @Override
    public void onBindViewHolder(@NonNull NearbyViewHolder nearbyViewHolder, int i) {
        final NearbyResort resort = resorts.get(i);
        nearbyViewHolder.bindData(resort);
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
            adapter.setSkiRuns(response.getSkiRuns());
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
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
