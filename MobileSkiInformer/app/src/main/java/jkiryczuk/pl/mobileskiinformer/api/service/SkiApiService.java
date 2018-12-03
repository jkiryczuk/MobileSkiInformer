package jkiryczuk.pl.mobileskiinformer.api.service;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.CountyResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import lombok.Getter;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SkiApiService {

    @GET("api/borough/{id}")
    Call<BoroughResponse> getBorough(@Path("id") Long id);

    @GET("api/skiresort/all")
    Call<List<SkiResortResponse>> getResorts();

    @GET("api/borough/by/county/{id}")
    Call<List<BoroughResponse>> getBoroughsByCounty(@Path("id") Long id);

    @GET("api/county/by/voivodeship/{id}")
    Call<List<CountyResponse>> getCountiesByVoivodeship(@Path("id") Long id);

    @GET("api/voivodeship/all")
    Call<List<VoivodeshipResponse>> getVoivodeships();

    @GET("/api/skiresort/by/borough/{id}")
    Call<List<SkiResortResponse>> getResortsInBorough(@Path("id") Long id);

    @GET("/api/skiresort/by/county/{id}")
    Call<List<SkiResortResponse>> getResortsInCounty(@Path("id") Long id);

    @GET("/api/skiresort/by/voivodeship/{id}")
    Call<List<SkiResortResponse>> getResortsInVoivodeship(@Path("id") Long id);

}
