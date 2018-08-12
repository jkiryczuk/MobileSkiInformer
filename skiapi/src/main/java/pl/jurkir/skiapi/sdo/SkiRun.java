package pl.jurkir.skiapi.sdo;

import lombok.Data;

//TODO MANY TO MANY
@Data
public class SkiRun {

    private Long id;
    private int length;
    private int heightDifference;

    public SkiRun(Long id, int length, int heightDifference) {
        this.id = id;
        this.length = length;
        this.heightDifference = heightDifference;
    }

    public SkiRun(pl.jurkir.skiapi.dao.SkiRun skiRun) {
        skiRun.setId(skiRun.getId());
        skiRun.setLength(skiRun.getLength());
        skiRun.setHeightDifference(skiRun.getHeightDifference());
    }

    public SkiRun() {
    }
}
