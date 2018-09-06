package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Voivodeship {

    private Long id;
    private String name;

    public Voivodeship(pl.jurkir.skiapi.dao.Voivodeship voivodeship) {
        this.id = voivodeship.getId();
        this.name = voivodeship.getName();

    }
}
