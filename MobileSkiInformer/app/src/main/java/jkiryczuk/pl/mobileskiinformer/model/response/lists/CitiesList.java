package jkiryczuk.pl.mobileskiinformer.model.response.lists;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.CityResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CitiesList {
    List<CityResponse> cities;
}
