package jkiryczuk.pl.mobileskiinformer.utils.bindingutils;

import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;


public class BindingAdapters {

    @BindingAdapter("setRefreshing")
    public static void setRefreshing(@NonNull final SwipeRefreshLayout view, Boolean isRefreshing) {
        view.setClickable(!isRefreshing);
        view.setRefreshing(isRefreshing);
    }

    @BindingAdapter("goneUnless")
    public static void goneUnless(@NonNull final View view, Boolean isVisible) {
        view.setVisibility(isVisible ? View.VISIBLE : View.GONE);
    }

    @BindingAdapter("disableButton")
    public static void disableButton(final View view, boolean isVisible) {
        if (isVisible) {
            view.setClickable(false);
        } else {
            view.setClickable(true);
        }
    }

}
