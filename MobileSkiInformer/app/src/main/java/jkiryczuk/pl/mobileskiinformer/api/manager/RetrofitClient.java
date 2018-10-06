package jkiryczuk.pl.mobileskiinformer.api.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitClient retrofitClient;

    private Retrofit retrofit;

    private RetrofitClient() {
    }

    public static synchronized RetrofitClient getInstance(String baseUrl, HttpClientType httpClientType) {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        retrofitClient.initRetrofit(baseUrl, httpClientType);
        return retrofitClient;
    }

    private void initRetrofit(String baseUrl, HttpClientType httpClientType) {
        final OkHttpClient okHttpClient = OkHttpClientManager.getInstance(httpClientType).getOkHttpClient();
        final Gson gson = new GsonBuilder().disableHtmlEscaping().create();
        retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public Retrofit getClient() {
        return retrofit;
    }
}
