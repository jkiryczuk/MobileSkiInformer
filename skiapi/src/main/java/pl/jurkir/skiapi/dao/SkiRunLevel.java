package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ski_run_levels")
public class SkiRunLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "level")
    private List<SkiRun> skiRuns = new ArrayList<>();
}
