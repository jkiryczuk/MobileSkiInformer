package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class SkiResort {

    private Long id;
    private String name;
    private String address;
    private String city;
    private float latitude;
    private float longitude;
    private String borough;

    public SkiResort(Long id, String name, String address, String city, float latitude, float longitude, String borough) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.borough = borough;
    }

    public SkiResort(pl.jurkir.skiapi.dao.SkiResort skiResort) {
        this.id = skiResort.getId();
        this.name = skiResort.getName();
        this.address = skiResort.getAddress();
        this.city = skiResort.getCity();
        this.latitude = skiResort.getLatitude();
        this.longitude = skiResort.getLongitude();
        this.borough = skiResort.getBorough().getName();
    }

    public SkiResort() {
    }
}
