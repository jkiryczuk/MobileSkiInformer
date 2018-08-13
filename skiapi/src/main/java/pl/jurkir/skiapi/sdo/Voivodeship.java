package pl.jurkir.skiapi.sdo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Voivodeship {

    private Long id;
    private String name;
    private List<County> counties;

    public Voivodeship(Long id, String name, List<County> counties) {
        this.id = id;
        this.name = name;
        this.counties = counties;
    }

    public Voivodeship(pl.jurkir.skiapi.dao.Voivodeship voivodeship) {
        this.id = voivodeship.getId();
        this.name = voivodeship.getName();
        List<County> counties = new ArrayList<>();
        for (int i = 0; i < voivodeship.getCounties().size(); i++) {
            County county = new County();
            county.setId(voivodeship.getCounties().get(i).getId());
            county.setName(voivodeship.getCounties().get(i).getName());
            Voivodeship voivodeshipDao = new Voivodeship();
            voivodeshipDao.setId(county.getVoivodeship().getId());
            voivodeshipDao.setName(county.getVoivodeship().getName());
            county.setVoivodeship(voivodeshipDao);
            List<Borough> boroughs = new ArrayList<>();
            for (int j = 0; j < county.getBoroughs().size(); j++) {
                Borough borough = new Borough();
                borough.setId(voivodeship.getCounties().get(i).getBoroughs().get(j).getId());
                borough.setName(voivodeship.getCounties().get(i).getBoroughs().get(j).getName());
                boroughs.add(borough);
            }
            county.setBoroughs(boroughs);
            counties.add(county);
        }
        this.counties = counties;
    }

    public Voivodeship() {
    }
}
