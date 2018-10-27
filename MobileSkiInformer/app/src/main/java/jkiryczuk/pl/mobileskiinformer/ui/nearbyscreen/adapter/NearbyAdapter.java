package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.NearbyModelBinding;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;

public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder> {

    private List<NearbyResort> resorts;
    private Context context;

    public NearbyAdapter(List<NearbyResort> resorts, Context context) {
        this.resorts = resorts;
        this.context = context;
        notifyDataSetChanged();
    }

    public void setResorts(List<NearbyResort> resorts) {
        this.resorts = resorts;
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

    }

    @Override
    public int getItemCount() {
        return resorts.size();
    }

    public void clear() {
        resorts.clear();
        notifyDataSetChanged();
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
