package jkiryczuk.pl.mobileskiinformer.api.manager;

import android.annotation.SuppressLint;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpClientManager {

    private static final int CONNECTION_TIMEOUT = 5000;
    private static final int READ_TIMEOUT = 5000;
    private static final int WRITE_TIMEOUT = 5000;

    private static OkHttpClientManager okHttpClientManager;
    private static OkHttpClient okHttpClient;

    private OkHttpClientManager() {
    }

    public static synchronized OkHttpClientManager getInstance(HttpClientType httpClientType) {
        if (okHttpClientManager == null) {
            okHttpClientManager = new OkHttpClientManager();
        }

        switch (httpClientType) {
            case Safe:
                okHttpClientManager.buildSafeHttpClient();
                break;
            case Unsafe:
                okHttpClientManager.buildUnsafeHttpClient();
                break;
            default:
                okHttpClientManager.buildUnsafeHttpClient();
        }

        return okHttpClientManager;
    }

    private void buildSafeHttpClient() {
        buildClient(new OkHttpClient().newBuilder());
    }

    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    private void buildUnsafeHttpClient() {
        try {
            // Create a trust manager that does not validate certificate chains
            final TrustManager[] trustAllCerts = new TrustManager[]{
                    new X509TrustManager() {
                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            //do nothing
                        }

                        @SuppressLint("TrustAllX509TrustManager")
                        @Override
                        public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) {
                            //do nothing
                        }

                        @Override
                        public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                            return new java.security.cert.X509Certificate[]{};
                        }
                    }
            };

            // Install the all-trusting trust manager
            final SSLContext sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustAllCerts, new java.security.SecureRandom());
            // Create an ssl socket factory with our all-trusting manager
            final SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
            final OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(sslSocketFactory, (X509TrustManager) trustAllCerts[0]);
            builder.hostnameVerifier((hostname, session) -> true);

            buildClient(builder);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void buildClient(OkHttpClient.Builder builder) {
        final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);

        okHttpClient = builder
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MILLISECONDS)
                .readTimeout(READ_TIMEOUT, TimeUnit.MILLISECONDS)
                .writeTimeout(WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }
}
