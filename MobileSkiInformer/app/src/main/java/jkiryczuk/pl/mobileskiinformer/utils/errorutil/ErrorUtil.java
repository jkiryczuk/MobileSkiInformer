package jkiryczuk.pl.mobileskiinformer.utils.errorutil;

import java.io.IOException;
import java.lang.annotation.Annotation;

import jkiryczuk.pl.mobileskiinformer.api.manager.RetrofitClient;
import jkiryczuk.pl.mobileskiinformer.model.NetworkError;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

import static jkiryczuk.pl.mobileskiinformer.Constants.HTTP_CLIENT_TYPE;
import static jkiryczuk.pl.mobileskiinformer.Constants.SERVICE_URL;

public class ErrorUtil {
    public static NetworkError parseError(Response<?> response) {
        final Converter<ResponseBody, NetworkError> converter =
                RetrofitClient.getInstance(SERVICE_URL, HTTP_CLIENT_TYPE).getClient()
                        .responseBodyConverter(NetworkError.class, new Annotation[0]);

        final NetworkError error;

        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new NetworkError();
        }

        return error;
    }
}