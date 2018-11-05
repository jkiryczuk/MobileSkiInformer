package jkiryczuk.pl.mobileskiinformer.model;

import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NearbyResort {
    private Long id;
    private String name;
    private String address;
    private String city;
    private float latitude;
    private float longitude;
    private String borough;
    private String image;
    private int distance = 0;
    private boolean favourite = false;

    public NearbyResort(SkiResortResponse response) {
        this.id = response.getId();
        this.name = response.getName();
        this.address = response.getAddress();
        this.city = response.getCity();
        this.latitude = response.getLatitude();
        this.longitude = response.getLongitude();
        this.borough = response.getBorough();
        this.image = response.getImage();
    }
}
