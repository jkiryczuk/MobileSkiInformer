package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class Borough {

    private Long id;
    private String name;
    private County county;

    public Borough(Long id, String name, County county) {
        this.id = id;
        this.name = name;
        this.county = county;
    }

    public Borough(pl.jurkir.skiapi.dao.Borough borough) {
        this.id = borough.getId();
        this.name = borough.getName();
        County county = new County();
        county.setId(county.getId());
        county.setName(county.getName());
        county.setVoivodeship(county.getVoivodeship());
        this.county = county;
    }

    public Borough() {
    }
}
