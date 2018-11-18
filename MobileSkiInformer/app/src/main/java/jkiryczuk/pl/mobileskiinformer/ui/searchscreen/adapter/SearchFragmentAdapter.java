package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.SearchItemBinding;
import jkiryczuk.pl.mobileskiinformer.model.ListOfFavourites;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiRunResponse;
import jkiryczuk.pl.mobileskiinformer.ui.adapter.ListInBottomSheetAdapter;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentAdapter.SearchViewHolder> {

    private List<NearbyResort> resorts;
    private Context context;
    private BottomSheetBehavior sheetBehavior;
    private FragmentSearchBinding binding;
    private List<NearbyResort> favs;

    public SearchFragmentAdapter(List<NearbyResort> resorts, Context context, BottomSheetBehavior sheetBehavior, FragmentSearchBinding binding) {
        this.resorts = resorts;
        this.context = context;
        this.sheetBehavior = sheetBehavior;
        this.binding = binding;
        favs = ListOfFavourites.getInstance().getResorts();
    }

    public void setResorts(List<NearbyResort> resorts) {
        this.resorts = resorts;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SearchFragmentAdapter.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.search_item, viewGroup, false);
        return new SearchFragmentAdapter.SearchViewHolder(view);
    }

    private void deleteFavsItem(long id) {
        for(int i=0;i<favs.size();i++){
            if(favs.get(i).getId() == id){
                favs.remove(i);
            }
        }
    }

    @Override
    public void onBindViewHolder(@NonNull SearchFragmentAdapter.SearchViewHolder searchViewHolder, int i) {
        final NearbyResort resort = resorts.get(i);
        searchViewHolder.bindData(resort);
        searchViewHolder.binding.counterSlopes.setText("Liczba stoków: "+resort.getSkiRuns().size());
        searchViewHolder.binding.starS.setOnClickListener(view -> {
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
        });
        if (searchViewHolder.binding != null) {
            StaticMethods.setMiniature(context,resort.getImage(), searchViewHolder.binding.miniature);
        }
        searchViewHolder.binding.cardNearby.setOnClickListener(v -> {
            ListInBottomSheetAdapter adapter = new ListInBottomSheetAdapter(resort.getSkiRuns(),context);
            binding.includeBS.listinbottomsheet.setAdapter(adapter);
            toggleBottomSheet(resort, adapter);

        });
    }

    public void toggleBottomSheet(NearbyResort response, ListInBottomSheetAdapter adapter) {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            binding.includeBS.setItem(response);
            binding.includeBS.counterSlopes.setText("Ilość stoków: "+String.valueOf(response.getSkiRuns().size()));
            adapter.setSkiRuns(response.getSkiRuns());
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
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

    static public class SearchViewHolder extends RecyclerView.ViewHolder {

        private final SearchItemBinding binding;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        void bindData(NearbyResort resort) {
            binding.setItem(resort);
        }
    }
}
