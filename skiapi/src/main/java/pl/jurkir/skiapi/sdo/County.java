package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class County {

    private Long id;
    private String name;
    private String voivodeship;

    public County(Long id, String name, String voivodeship) {
        this.id = id;
        this.name = name;
        this.voivodeship = voivodeship;
    }

    public County(pl.jurkir.skiapi.dao.County county) {
        this.id = county.getId();
        this.name = county.getName();
        this.voivodeship = county.getVoivodeship().getName();
    }

    public County() {
    }
}
