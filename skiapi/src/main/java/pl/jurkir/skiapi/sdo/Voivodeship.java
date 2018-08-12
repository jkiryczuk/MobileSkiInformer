package pl.jurkir.skiapi.sdo;

import lombok.Data;

import java.util.List;

@Data
public class Voivodeship {

    private Long id;
    private String name;
    private List<County> counties;
}
