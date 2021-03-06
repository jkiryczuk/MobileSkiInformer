package jkiryczuk.pl.mobileskiinformer.utils.bindingutils;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.di.GlideApp;


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

    @BindingAdapter("bind:imageUrl")
    public static void setImageUrl(ImageView imageView, String imageUrl) {
        final Context context = imageView.getContext();
        GlideApp.with(context)
                .load(imageUrl)
                .error(R.drawable.error_image_icon)
                .into(imageView);
    }

    @BindingAdapter("favouriteState")
    public static void favouriteState(ImageView imageView, boolean state){
        if(!state){
            imageView.setImageResource(R.drawable.white);
        } else {
            imageView.setImageResource(R.drawable.gold);
        }

    }

    @BindingAdapter("colorLevel")
    public static void changeColorLevel(ImageView imageView, String level){
        if(level.equals("czerwona")){
            imageView.setImageResource(R.drawable.czerwony);
        } else if(level.equals("czarna")){
            imageView.setImageResource(R.drawable.czarna);
        } else if(level.equals("zielona")){
            imageView.setImageResource(
                    R.drawable.zielona);
        }

    }

    @BindingAdapter("typeOfLift")
    public static void changeLift(ImageView imageView, String level){
        if(level.equals("krzesełkowa")){
            imageView.setImageResource(R.mipmap.krzes);
        } else if(level.equals("orczykowa")){
            imageView.setImageResource(R.mipmap.orczyk);
        } else if(level.equals("linowa") || level.equals("gondolowa")
                ||level.equals("linowo-terenowa")|| level.equals("koszykowa")){
            imageView.setImageResource(R.mipmap.kolejka);
        }
    }
}
