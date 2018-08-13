package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class Voivodeship {

    private Long id;
    private String name;

    public Voivodeship(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Voivodeship(pl.jurkir.skiapi.dao.Voivodeship voivodeship) {
        this.id = voivodeship.getId();
        this.name = voivodeship.getName();

    }

    public Voivodeship() {
    }
}
