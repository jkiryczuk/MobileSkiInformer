package jkiryczuk.pl.mobileskiinformer.ui.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.RunItemBinding;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiRunResponse;

public class ListInBottomSheetAdapter extends  RecyclerView.Adapter<ListInBottomSheetAdapter.ListInBottomSheetViewHolder> {

    List<SkiRunResponse> skiRuns;
    private Context context;


    public ListInBottomSheetAdapter(List<SkiRunResponse> skiRuns, Context context) {
        this.skiRuns = skiRuns;
        this.context = context;
    }

    public void setSkiRuns(List<SkiRunResponse> skiRuns) {
        this.skiRuns = skiRuns;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListInBottomSheetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.run_item,viewGroup,false);
        return new ListInBottomSheetAdapter.ListInBottomSheetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListInBottomSheetViewHolder listInBottomSheetViewHolder, int i) {
        final SkiRunResponse run = skiRuns.get(i);
        listInBottomSheetViewHolder.bindData(run);
    }


    @Override
    public int getItemCount() {
        return skiRuns.size();
    }

    static public class ListInBottomSheetViewHolder extends RecyclerView.ViewHolder {

        private final RunItemBinding binding;

        public ListInBottomSheetViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        void bindData(SkiRunResponse run) {binding.setItem(run);}
    }
}
