package jkiryczuk.pl.mobileskiinformer.ui.mainactivity;

import android.databinding.DataBindingUtil;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import jkiryczuk.pl.mobileskiinformer.R;
import jkiryczuk.pl.mobileskiinformer.databinding.ActivityMainBinding;
import jkiryczuk.pl.mobileskiinformer.ui.favouritescreen.FavouritesFragment;
import jkiryczuk.pl.mobileskiinformer.ui.nearbyscreen.NearbyFragment;
import jkiryczuk.pl.mobileskiinformer.ui.searchscreen.SearchFragment;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel viewModel;

    final Fragment fragment1 = new FavouritesFragment();
    final Fragment fragment2 = new SearchFragment();
    final Fragment fragment3 = new NearbyFragment();
    final FragmentManager fm = getSupportFragmentManager();
    Fragment active = fragment1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel.fetchTestData();
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        BottomNavigationView navigation = binding.bottomNavigation;
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.fragmentFrame, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.fragmentFrame, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.fragmentFrame,fragment1, "1").commit();
        binding.setBinding(viewModel);
        viewModel.fetchTestData();
        initializeObservers();
    }

    private void initializeObservers() {
        observeTestLiveData();
    }

    private void observeTestLiveData() {
        viewModel.getServerResponse().observe(this, boroughResponseResource -> {
            if((boroughResponseResource == null
                    || boroughResponseResource.getData() == null)){
                Log.e("ERROR","Some fetch data is null");
                return;
            }
            Log.d("WORK", "DATA FETCH FROM SERVER");
            viewModel.setBoroughResponse(boroughResponseResource.getData());
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {
                    case R.id.action_favorites:
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;

                    case R.id.action_search:
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;

                    case R.id.action_nearby:
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        return true;
                }
                return false;
            };
}
