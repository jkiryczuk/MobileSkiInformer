package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Borough {

    private Long id;
    private String name;
    private String county;

    public Borough(pl.jurkir.skiapi.dao.Borough borough) {
        this.id = borough.getId();
        this.name = borough.getName();
        this.county = borough.getCounty().getName();
    }
}
