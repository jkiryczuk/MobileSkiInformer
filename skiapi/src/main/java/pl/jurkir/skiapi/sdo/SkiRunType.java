package pl.jurkir.skiapi.sdo;

import lombok.Data;

@Data
public class SkiRunType {

    private Long id;
    private String name;

    public SkiRunType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public SkiRunType(pl.jurkir.skiapi.dao.SkiRunType skiRunType) {
        this.id = skiRunType.getId();
        this.name = skiRunType.getName();
    }

    public SkiRunType() {
    }
}
