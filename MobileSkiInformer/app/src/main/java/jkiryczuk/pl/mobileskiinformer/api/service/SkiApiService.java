package jkiryczuk.pl.mobileskiinformer.api.service;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SkiApiService {

    @GET("api/borough/{id}")
    Call<BoroughResponse> getBorough(@Path("id") Long id);

    @GET("api/skiresort/all")
    Call<List<SkiResortResponse>> getResorts();
}
