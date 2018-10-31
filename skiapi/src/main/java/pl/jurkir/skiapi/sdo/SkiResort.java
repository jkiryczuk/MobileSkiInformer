package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkiResort {

    private Long id;
    private String name;
    private String address;
    private String city;
    private String phonenumber;
    private String website;
    private String mapadress;
    private float latitude;
    private float longitude;
    private String borough;

    public SkiResort(pl.jurkir.skiapi.dao.SkiResort skiResort) {
        this.id = skiResort.getId();
        this.name = skiResort.getName();
        this.address = skiResort.getAddress();
        this.city = skiResort.getCity();
        this.phonenumber= skiResort.getPhonenumber();
        this.website = skiResort.getWebsite();
        this.mapadress = skiResort.getMapadress();
        this.latitude = skiResort.getLatitude();
        this.longitude = skiResort.getLongitude();
        this.borough = skiResort.getBorough().getName();
    }
}
