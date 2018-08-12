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
    private Borough borough;

    public SkiResort(Long id, String name, String address, String city, float latitude, float longitude, Borough borough) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.borough = borough;
    }

    public SkiResort(SkiResort skiResort) {
        this.id = skiResort.getId();
        this.name = skiResort.getName();
        this.address = skiResort.getAddress();
        this.city = skiResort.getCity();
        this.latitude = skiResort.getLatitude();
        this.longitude = skiResort.getLongitude();
        Borough borough = new Borough();
        borough.setId(skiResort.getBorough().getId());
        borough.setName(skiResort.getBorough().getName());
        County county = new County();
        county.setId(skiResort.getBorough().getCounty().getId());
        county.setName(skiResort.getBorough().getCounty().getName());
        Voivodeship voivodeship = new Voivodeship();
        voivodeship.setId(skiResort.getBorough().getCounty().getVoivodeship().getId());
        voivodeship.setName(skiResort.getBorough().getCounty().getVoivodeship().getName());
        county.setVoivodeship(voivodeship);
        borough.setCounty(county);
        this.borough = borough;
    }

    public SkiResort() {
    }
}
