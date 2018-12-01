package jkiryczuk.pl.mobileskiinformer.model.response;

import lombok.Data;

@Data
public class CountyResponse {
    private Long id;
    private String name;
    private String voivodeship;

    @Override
    public String toString() {
        return name;
    }
}
