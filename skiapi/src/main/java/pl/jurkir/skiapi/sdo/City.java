package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class City {

    private Long id;
    private String name;
    private double lat;
    private double lng;

    public City(pl.jurkir.skiapi.dao.City city) {
        this.id = city.getId();
        this.name = city.getName();
        this.lat = city.getLat();
        this.lng = city.getLng();
    }
}

