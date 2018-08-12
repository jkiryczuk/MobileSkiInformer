package pl.jurkir.skiapi.sdo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

//TODO dodać listę gmin -- czy konieczne?
@Data
public class County {

    private Long id;
    private String name;
    private Voivodeship voivodeship;
    private List<Borough> boroughs;

    public County(Long id, String name, Voivodeship voivodeship, List<Borough> boroughs) {
        this.id = id;
        this.name = name;
        this.voivodeship = voivodeship;
        this.boroughs = boroughs;
    }

    public County(pl.jurkir.skiapi.dao.County county) {
        this.id = county.getId();
        this.name = county.getName();
        Voivodeship voivodeship = new Voivodeship();
        voivodeship.setId(county.getVoivodeship().getId());
        voivodeship.setName(county.getVoivodeship().getName());
        this.voivodeship = voivodeship;
        List<Borough> boroughs = new ArrayList<>();
        for (int i = 0; i < county.getBoroughs().size(); i++) {
            Borough borough = new Borough();
            borough.setId(county.getBoroughs().get(i).getId());
            borough.setName(county.getBoroughs().get(i).getName());
            boroughs.add(borough);
        }
        this.boroughs = boroughs;
    }

    public County() {
    }
}
