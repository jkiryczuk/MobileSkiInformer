package pl.jurkir.skiapi.sdo;

import lombok.Data;

//TODO dodać listę gmin
@Data
public class County {

    private Long id;
    private String name;
    private Voivodeship voivodeship;

    public County(Long id, String name, Voivodeship voivodeship) {
        this.id = id;
        this.name = name;
        this.voivodeship = voivodeship;
    }

    public County(pl.jurkir.skiapi.dao.County county) {
        this.id = county.getId();
        this.name = county.getName();
        Voivodeship voivodeship = new Voivodeship();
        voivodeship.setId(county.getVoivodeship().getId());
        voivodeship.setName(county.getVoivodeship().getName());
        this.voivodeship = voivodeship;
    }

    public County() {
    }
}
