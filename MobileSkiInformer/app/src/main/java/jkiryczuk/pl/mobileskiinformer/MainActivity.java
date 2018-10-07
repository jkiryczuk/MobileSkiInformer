package jkiryczuk.pl.mobileskiinformer;

import android.arch.lifecycle.Observer;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import jkiryczuk.pl.mobileskiinformer.databinding.ActivityMainBinding;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;

public class MainActivity extends AppCompatActivity {

    @Inject
    MainActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        viewModel.fetchTestData();
        final ActivityMainBinding binding = DataBindingUtil.setContentView(this,
                R.layout.activity_main);
        binding.setBinding(viewModel);
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
            //            TextView view = findViewById(R.id.textView);
//            view.setText(boroughResponseResource.getData().getName());

        });
    }
}
