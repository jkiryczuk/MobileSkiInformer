package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "counties")
public class County {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "voivodeship", nullable = false)
    private Voivodeship voivodeship;

    @OneToMany(mappedBy = "county")
    private List<Borough> boroughs;
}
