package jkiryczuk.pl.mobileskiinformer.repository;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import java.util.List;

import javax.inject.Inject;

import jkiryczuk.pl.mobileskiinformer.api.manager.RetrofitClient;
import jkiryczuk.pl.mobileskiinformer.api.service.SkiApiService;
import jkiryczuk.pl.mobileskiinformer.model.NetworkError;
import jkiryczuk.pl.mobileskiinformer.model.ResortsList;
import jkiryczuk.pl.mobileskiinformer.model.Resource;
import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.utils.errorutil.ErrorUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

import static jkiryczuk.pl.mobileskiinformer.Constants.HTTP_CLIENT_TYPE;
import static jkiryczuk.pl.mobileskiinformer.Constants.SERVICE_URL;

public class SkiDataRepository implements DataRepository {

    private final SkiApiService service;

    @Inject
    SkiDataRepository() {
        final Retrofit retrofit = RetrofitClient.getInstance(SERVICE_URL, HTTP_CLIENT_TYPE).getClient();
        service = retrofit.create(SkiApiService.class);
    }

    @Override
    public void getBorough(Long id, MutableLiveData<Resource<BoroughResponse>> liveData) {
        final Call<BoroughResponse> call = service.getBorough(id);
        commitNetworkCall(call, liveData);
    }

    @Override
    public void getResorts(MutableLiveData<Resource<ResortsList>> liveData) {
        final Call<List<SkiResortResponse>> call = service.getResorts();
        commitResortscall(call, liveData);
    }

    private void commitResortscall(Call<List<SkiResortResponse>> call, MutableLiveData<Resource<ResortsList>> liveData) {
        call.enqueue(new Callback<List<SkiResortResponse>>() {
            @Override
            public void onResponse(Call<List<SkiResortResponse>> call, Response<List<SkiResortResponse>> response) {
                if (liveData == null) {
                    return;
                }

                NetworkError networkError = null;
                if (response.errorBody() != null) {
                    networkError = ErrorUtil.parseError(response);
                }
                final ResortsList resortsList = new ResortsList();
                if (response.isSuccessful()) {
                    resortsList.setResortsList(response.body());
                    liveData.setValue(Resource.success(resortsList));
                } else {
                    liveData.setValue(Resource.error(networkError.getMessage(), resortsList));
                }
            }

            @Override
            public void onFailure(Call<List<SkiResortResponse>> call, Throwable t) {
                liveData.setValue(Resource.failure());
            }
        });
    }

    private <ResponseT>
    void commitNetworkCall(Call<ResponseT> call,
                           final MutableLiveData<Resource<ResponseT>> liveData) {

        call.enqueue(new Callback<ResponseT>() {
            @Override
            public void onResponse(@NonNull Call<ResponseT> call, @NonNull Response<ResponseT> response) {
                if (liveData == null)
                    return;

                NetworkError networkError = null;
                if (response.errorBody() != null) {
                    networkError = ErrorUtil.parseError(response);
                }

                if (response.isSuccessful()) {
                    liveData.setValue(Resource.success(response.body()));
                } else {
                    liveData.setValue(Resource.error(networkError.getMessage(), response.body()));
                }
            }

            @Override
            public void onFailure(@NonNull Call<ResponseT> call, @NonNull Throwable t) {
                liveData.setValue(Resource.failure());
            }
        });
    }

}
