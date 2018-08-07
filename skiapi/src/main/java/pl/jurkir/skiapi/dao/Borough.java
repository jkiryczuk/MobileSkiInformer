package pl.jurkir.skiapi.dao;

import javax.persistence.*;
import java.util.List;

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

    public Borough() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public County getCounty() {
        return county;
    }

    public void setCounty(County county) {
        this.county = county;
    }
}
