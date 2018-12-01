package jkiryczuk.pl.mobileskiinformer.model.response.lists;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.VoivodeshipResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VoivodeshipsList {
    List<VoivodeshipResponse> voivodeshipsList;
}
