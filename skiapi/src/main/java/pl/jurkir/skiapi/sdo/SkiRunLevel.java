package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class SkiRunLevel {

    private Long id;
    private String name;

    public SkiRunLevel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkiRunLevel(pl.jurkir.skiapi.dao.SkiRunLevel skiRunLevel) {
        this.id = skiRunLevel.getId();
        this.name = skiRunLevel.getName();
    }

    public SkiRunLevel() {
    }
}

