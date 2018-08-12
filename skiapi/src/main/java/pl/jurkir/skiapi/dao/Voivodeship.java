package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
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
}
