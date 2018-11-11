package jkiryczuk.pl.mobileskiinformer.utils;

import android.content.Context;
import android.support.design.widget.BottomSheetBehavior;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

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

}
