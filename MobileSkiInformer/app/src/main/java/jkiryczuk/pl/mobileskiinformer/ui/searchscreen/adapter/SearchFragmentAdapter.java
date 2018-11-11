package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.adapter;

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

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.SearchItemBinding;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiRunResponse;
import jkiryczuk.pl.mobileskiinformer.utils.StaticMethods;

public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentAdapter.SearchViewHolder> {

    private List<NearbyResort> resorts;
    private Context context;
    private BottomSheetBehavior sheetBehavior;
    private FragmentSearchBinding binding;

    public SearchFragmentAdapter(List<NearbyResort> resorts, Context context, BottomSheetBehavior sheetBehavior, FragmentSearchBinding binding) {
        this.resorts = resorts;
        this.context = context;
        this.sheetBehavior = sheetBehavior;
        this.binding = binding;
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

    @Override
    public void onBindViewHolder(@NonNull SearchFragmentAdapter.SearchViewHolder searchViewHolder, int i) {
        final NearbyResort resort = resorts.get(i);
        searchViewHolder.bindData(resort);
        searchViewHolder.binding.cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet(resort);

            }
        });
    }

    public void toggleBottomSheet(NearbyResort response) {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            binding.includeBS.setItem(response);
//            binding.includeBS.nameOfResort.setText(response.getName());
//            binding.includeBS.addressOfResort.setText(response.getAddress());
//            binding.includeBS.cityOfRessort.setText(response.getCity());
//            binding.includeBS.list.setText("Ilość stoków: "+String.valueOf(response.getSkiRuns().size()));
            StaticMethods.setMiniature(context,response.getImage(),binding.includeBS.obrazek);
            StringBuffer buffer = new StringBuffer();
            for(SkiRunResponse run : response.getSkiRuns()){
                buffer.append("Trasa: "+run.getSkiRunLevel()+", "+run.getSkiRunType()+" o długości "+run.getLength()+"m i przewyższeniu "+run.getHeightDifference()+"m\n");
            }
            binding.includeBS.listInfo.setText(buffer.toString());

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
