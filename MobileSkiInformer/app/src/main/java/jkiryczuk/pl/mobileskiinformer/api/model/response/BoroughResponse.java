package jkiryczuk.pl.mobileskiinformer.api.model.response;

import lombok.Data;

@Data
public class BoroughResponse {
    private Long id;
    private String name;
    private String county;
}
