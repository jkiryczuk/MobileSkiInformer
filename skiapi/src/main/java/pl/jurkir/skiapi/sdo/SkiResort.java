package pl.jurkir.skiapi.sdo;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

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
    private String image;
    private List<SkiRun> skiRuns;

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
        this.image= skiResort.getImage();
        skiRuns = new ArrayList<>();
        for( pl.jurkir.skiapi.dao.SkiRun skiRun : skiResort.getSkiRuns()){
            skiRuns.add(new SkiRun(skiRun));
        }
    }
}
