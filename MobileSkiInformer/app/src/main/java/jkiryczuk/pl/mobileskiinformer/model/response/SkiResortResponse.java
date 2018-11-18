package jkiryczuk.pl.mobileskiinformer.model.response;

import java.util.List;

import lombok.Data;

@Data
public class SkiResortResponse {
    private Long id;
    private String name;
    private String address;
    private String city;
    private float latitude;
    private float longitude;
    private String borough;
    private String image;
    private String phonenumber;
    private String website;
    private String mapadress;
    private List<SkiRunResponse> skiRuns;
}
