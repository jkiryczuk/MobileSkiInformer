package jkiryczuk.pl.mobileskiinformer.model;

import android.support.annotation.Nullable;

import lombok.Data;
import lombok.NonNull;

@Data
public class Resource<T> {

    @NonNull
    private final Status status;
    @Nullable
    private final T data;
    @Nullable
    private final String message;

    public static <T> Resource<T> success(@Nullable T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(Status.ERROR, data, msg);
    }

    public static <T> Resource<T> failure() {
        return new Resource<>(Status.ERROR, null, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING}
}
