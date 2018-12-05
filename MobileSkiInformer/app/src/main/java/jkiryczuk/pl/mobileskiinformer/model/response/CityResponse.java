package jkiryczuk.pl.mobileskiinformer.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CityResponse {
    private float id;
    private String name;
    private float lat;
    private float lng;

    @Override
    public String toString() {
        return name;
    }
}
