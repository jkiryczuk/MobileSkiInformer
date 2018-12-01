package jkiryczuk.pl.mobileskiinformer.model.response.lists;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.BoroughResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoroughsList {
    List<BoroughResponse> boroughsList;
}
