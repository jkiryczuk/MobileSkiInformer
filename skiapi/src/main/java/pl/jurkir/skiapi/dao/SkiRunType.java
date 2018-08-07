package pl.jurkir.skiapi.dao;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ski_run_types")
public class SkiRunType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "type")
    private List<SkiRun> skiRuns = new ArrayList<>();

    public SkiRunType() {
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

    public List<SkiRun> getSkiRuns() {
        return skiRuns;
    }

    public void setSkiRuns(List<SkiRun> skiRuns) {
        this.skiRuns = skiRuns;
    }
}
