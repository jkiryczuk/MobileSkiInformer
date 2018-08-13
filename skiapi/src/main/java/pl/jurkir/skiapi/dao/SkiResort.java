package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;

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
    @Column(name = "latitude")
    private float latitude;
    @Column(name = "longitude")
    private float longitude;
    @ManyToOne
    @JoinColumn(name = "borough", nullable = false)
    private Borough borough;
}