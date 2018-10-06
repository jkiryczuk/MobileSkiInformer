package jkiryczuk.pl.mobileskiinformer.utils.sharedprefsutils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Singleton;

import static jkiryczuk.pl.mobileskiinformer.Constants.SH_NAME_LOGIN;

@Singleton
public class SharedPrefsUtils implements SharedPrefs {

    private final SharedPreferences sharedPreferences;

    @Inject
    public SharedPrefsUtils(Context context) {
        this.sharedPreferences = context.getSharedPreferences(SH_NAME_LOGIN, Context.MODE_PRIVATE);
    }

    @Override
    public void clearSharedPrefs() {
        sharedPreferences.edit().clear().apply();
    }
}
