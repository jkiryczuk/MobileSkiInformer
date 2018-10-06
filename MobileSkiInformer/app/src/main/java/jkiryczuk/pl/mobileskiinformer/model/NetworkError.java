package jkiryczuk.pl.mobileskiinformer.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NetworkError {
    private String timestamp;
    private int errorCode;
    private String errorName;
    private String message;
    private String path;
}
