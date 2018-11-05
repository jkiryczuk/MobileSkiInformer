package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "ski_resorts")
public class SkiResort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "website")
    private String website;
    @Column(name = "map_adress")
    private String mapadress;
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;
    @Column (name = "image")
    private String image;
    @ManyToOne
    @JoinColumn(name = "borough", nullable = false)
    private Borough borough;
    @OneToMany(mappedBy = "resort")
    List<SkiRun> skiRuns;
}
