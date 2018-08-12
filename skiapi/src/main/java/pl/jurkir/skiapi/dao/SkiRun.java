package pl.jurkir.skiapi.dao;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "ski_runs")
public class SkiRun {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "length")
    private int length;
    @Column(name = "height_difference")
    private int heightDifference;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "ski_run_ski_run_type",
            joinColumns = {@JoinColumn(name = "ski_run_id")},
            inverseJoinColumns = {@JoinColumn(name = "ski_run_type_id")}
    )
    private List<SkiRunType> type = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "ski_run_ski_run_level",
            joinColumns = {@JoinColumn(name = "ski_run_id")},
            inverseJoinColumns = {@JoinColumn(name = "ski_run_level_id")}
    )
    private List<SkiRunLevel> level = new ArrayList<>();
}
