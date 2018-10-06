package jkiryczuk.pl.mobileskiinformer.api.service;

import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SkiApiService {

    @GET("api/borough/{id}")
    Call<BoroughResponse> getBorough(@Path("id") Long id);
}
