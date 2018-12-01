package jkiryczuk.pl.mobileskiinformer.model.response;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoroughResponse {
    private Long id;
    private String name;
    private String county;

    @Override
    public String toString() {
        return name;
    }
}
