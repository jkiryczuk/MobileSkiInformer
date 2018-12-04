package jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;

import jkiryczuk.pl.mobileskiinformer.R;


public class NewTaskDialogFragment extends DialogFragment implements
        android.view.View.OnClickListener {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        LayoutInflater inflater = LayoutInflater.from(context);
        View dialogView= inflater.inflate(R.layout.dialog_choose_city_nearby_fragment, null);
        builder.setView(dialogView);

        return builder.create();
    }
    @Override
    public void onClick(View view) {

    }
}