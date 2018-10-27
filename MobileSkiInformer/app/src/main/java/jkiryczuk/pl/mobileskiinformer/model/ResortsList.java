package jkiryczuk.pl.mobileskiinformer.model;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResortsList {
    List<SkiResortResponse> resortsList;
}
