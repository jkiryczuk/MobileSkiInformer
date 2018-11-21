package jkiryczuk.pl.mobileskiinformer.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.model.NearbyResort;
import jkiryczuk.pl.mobileskiinformer.ui.adapter.ListInBottomSheetAdapter;

public class StaticMethods {

    public static void setMiniature(Context context, String image, ImageView miniature) {
        Glide
                .with(context)
                .load(image)
                .apply(new RequestOptions()
                        .error(R.drawable.error_image_icon))
                .into(miniature);
    }

    public static void filterList(List<NearbyResort> serverResponse, List<NearbyResort> favs) {
        for (NearbyResort response : serverResponse) {
            for (NearbyResort fav : favs) {
                if (response.getId().equals(fav.getId())) {
                    response.setFavourite(true);
                }
            }
        }
    }

    public static void toggleBottomSheet(NearbyResort response,
                                         ListInBottomSheetAdapter adapter,
                                         BottomSheetBehavior sheetBehavior,
                                         Context context,
                                         TextView counterSlopes,
                                         ImageButton callButton,
                                         ImageButton webButton,
                                         ImageButton mapButton,
                                         ImageButton navigationButton) {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            counterSlopes.setText("Ilość stoków: " + String.valueOf(response.getSkiRuns().size()));
            if (response.getPhonenumber().equals("mock") || response.getPhonenumber().equals("-")) {
              callButton.setVisibility(View.GONE);
            }
            if (response.getWebsite().equals("mock") || response.getWebsite().equals("-")) {
                webButton.setVisibility(View.GONE);
            }
            if (response.getMapadress().equals("mock") || response.getMapadress().equals("-")) {
                mapButton.setVisibility(View.GONE);
            }

            callButton.setOnClickListener(view -> {
                makeCall(response,context);
            });
            webButton.setOnClickListener(view -> {
                openSite(response, 0,context);
            });
            mapButton.setOnClickListener(view -> {
                openSite(response, 1,context);
            });
            navigationButton.setOnClickListener(view -> {
                openMaps(response,context);
            });
            adapter.setSkiRuns(response.getSkiRuns());
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        }
    }

    public static void makeCall(NearbyResort resort, Context context) {
        final Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", resort.getPhonenumber(), null));
        context.startActivity(intent);
    }

    public static void openSite(NearbyResort resort, int type, Context context) {
        final Intent i = new Intent(Intent.ACTION_VIEW);
        if (type == 0) { //is website
            i.setData(Uri.parse(resort.getWebsite()));
        } else if (type == 1) {//is map
            i.setData(Uri.parse(resort.getMapadress()));
        }
        context.startActivity(i);
    }

    public static void openMaps(NearbyResort resort, Context context) {
        final Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + resort.getLatitude() + "," + resort.getLongitude());
        final Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        context.startActivity(mapIntent);
    }
}
