package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class Borough {

    private Long id;
    private String name;
    private String county;

    public Borough(Long id, String name, String county) {
        this.id = id;
        this.name = name;
        this.county = county;
    }

    public Borough(pl.jurkir.skiapi.dao.Borough borough) {
        this.id = borough.getId();
        this.name = borough.getName();
        this.county = borough.getCounty().getName();
    }

    public Borough() {
    }
}
