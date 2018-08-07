package pl.jurkir.skiapi.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeightDiffrence() {
        return heightDifference;
    }

    public void setHeightDiffrence(int heightDifference) {
        this.heightDifference = heightDifference;
    }

    public int getHeightDifference() {
        return heightDifference;
    }

    public void setHeightDifference(int heightDifference) {
        this.heightDifference = heightDifference;
    }

    public List<SkiRunType> getType() {
        return type;
    }

    public void setType(List<SkiRunType> type) {
        this.type = type;
    }

    public List<SkiRunLevel> getLevel() {
        return level;
    }

    public void setLevel(List<SkiRunLevel> level) {
        this.level = level;
    }
}
