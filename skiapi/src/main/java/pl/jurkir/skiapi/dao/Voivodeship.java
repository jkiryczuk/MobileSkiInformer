package pl.jurkir.skiapi.dao;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "voivodeships")
public class Voivodeship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "voivodeship")
    private List<County> counties;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<County> getCounty() {
        return counties;
    }

    public void setCounty(List<County> counties) {
        this.counties = counties;
    }

    public Voivodeship() {
    }
}
