package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "boroughs")
public class Borough {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "county", nullable = false)
    private County county;

    @OneToMany(mappedBy = "borough")
    private List<SkiResort> resorts;
}
