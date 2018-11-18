package jkiryczuk.pl.mobileskiinformer.utils;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;

public class StaticMethods {

    public static void setMiniature(Context context, String image, ImageView miniature) {
        Glide
                .with(context)
                .load(image)
                .apply(new RequestOptions()
                        .error(R.drawable.error_image_icon))
                .into(miniature);
    }

    public static void filterList(List<NearbyResort> serverResponse, List<NearbyResort> favs){
        for(NearbyResort response: serverResponse){
            for (NearbyResort fav : favs){
                if(response.getId().equals(fav.getId())){
                        response.setFavourite(true);
                }
            }
        }
    }


}
