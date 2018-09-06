package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class County {

    private Long id;
    private String name;
    private String voivodeship;

    public County(pl.jurkir.skiapi.dao.County county) {
        this.id = county.getId();
        this.name = county.getName();
        this.voivodeship = county.getVoivodeship().getName();
    }
}
