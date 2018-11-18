package jkiryczuk.pl.mobileskiinformer.model;

import java.util.List;

import jkiryczuk.pl.mobileskiinformer.model.response.SkiResortResponse;
import jkiryczuk.pl.mobileskiinformer.model.response.SkiRunResponse;
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
    private String phonenumber;
    private String website;
    private String mapadress;
    private String image;
    private float distance = 0;
    private boolean favourite = false;
    private List<SkiRunResponse> skiRuns;

    public NearbyResort(SkiResortResponse response) {
        this.id = response.getId();
        this.name = response.getName();
        this.address = response.getAddress();
        this.city = response.getCity();
        this.latitude = response.getLatitude();
        this.longitude = response.getLongitude();
        this.borough = response.getBorough();
        this.phonenumber= response.getPhonenumber();
        this.website = response.getWebsite();
        this.mapadress = response.getMapadress();
        this.image = response.getImage();
        this.skiRuns = response.getSkiRuns();
    }

    public NearbyResort() {
    }

    public String getDistance(){
        return (int) distance +"km";
    }

    public float showDistanceNumbered(){
        return distance;
    }

}
