package jkiryczuk.pl.mobileskiinformer.model.response;

import lombok.Data;

@Data
public class VoivodeshipResponse {
    private Long id;
    private String name;

    @Override
    public String toString() {
        return  name;
    }
}
