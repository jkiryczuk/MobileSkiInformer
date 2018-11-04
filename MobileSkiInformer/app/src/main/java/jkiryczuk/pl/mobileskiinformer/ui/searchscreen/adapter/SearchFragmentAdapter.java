package jkiryczuk.pl.mobileskiinformer.ui.searchscreen.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.FragmentSearchBinding;
import jkiryczuk.pl.mobileskiinformer.databinding.SearchItemBinding;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;

public class SearchFragmentAdapter extends RecyclerView.Adapter<SearchFragmentAdapter.SearchViewHolder> {

    private List<SkiResortResponse> resorts;
    private Context context;
    private BottomSheetBehavior sheetBehavior;
    private FragmentSearchBinding binding;

    public SearchFragmentAdapter(List<SkiResortResponse> resorts, Context context, BottomSheetBehavior sheetBehavior, FragmentSearchBinding binding) {
        this.resorts = resorts;
        this.context = context;
        this.sheetBehavior = sheetBehavior;
        this.binding = binding;
    }

    public void setResorts(List<SkiResortResponse> resorts) {
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
        final SkiResortResponse resort = resorts.get(i);
        searchViewHolder.bindData(resort);
        searchViewHolder.binding.cardSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleBottomSheet(resort);

            }
        });
    }

    public void toggleBottomSheet(SkiResortResponse response) {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            binding.includeBS.gowno.setText(response.getName());

        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//            btnBottomSheet.setText("Expand sheet");
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

        void bindData(SkiResortResponse resort) {
            binding.setItem(resort);
        }
    }
}
