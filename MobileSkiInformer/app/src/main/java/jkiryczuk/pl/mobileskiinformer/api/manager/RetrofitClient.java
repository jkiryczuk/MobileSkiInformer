package jkiryczuk.pl.mobileskiinformer.api.manager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final int CONNECTION_TIMEOUT = 15;
    private static final int READ_TIMEOUT = 10;
    private static final int WRITE_TIMEOUT = 10;

    private Retrofit retrofit;

    public RetrofitClient() {
    }

    public static RetrofitClient getInstance(String baseUrl) {
        RetrofitClient retrofitClient = new RetrofitClient();
        retrofitClient.initRetrofit(baseUrl);

        return retrofitClient;
    }

    private void initRetrofit(String baseUrl) {

        final HttpLoggingInterceptor logging =
                new HttpLoggingInterceptor()
                        .setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient okHttpClient =
                new OkHttpClient().newBuilder()
                        .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                        .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
                        .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
                        .addInterceptor(logging)
                        .build();

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
