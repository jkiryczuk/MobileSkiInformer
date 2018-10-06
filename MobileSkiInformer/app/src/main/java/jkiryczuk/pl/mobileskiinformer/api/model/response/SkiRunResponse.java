package jkiryczuk.pl.mobileskiinformer.api.model.response;

import lombok.Data;

@Data
public class SkiRunResponse {
    private Long id;
    private int length;
    private int heightDifference;
    private String skiRunType;
    private String skiRunLevel;

}
