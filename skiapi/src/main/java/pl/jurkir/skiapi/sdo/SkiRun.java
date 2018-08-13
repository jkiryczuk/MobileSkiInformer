package pl.jurkir.skiapi.sdo;

import lombok.Data;

//TODO MANY TO MANY
@Data
public class SkiRun {

    private Long id;
    private int length;
    private int heightDifference;
    private String skiRunType;
    private String skiRunLevel;

    public SkiRun(Long id, int length, int heightDifference, String skiRunType, String skiRunLevel) {
        this.id = id;
        this.length = length;
        this.heightDifference = heightDifference;
        this.skiRunType = skiRunType;
        this.skiRunLevel = skiRunLevel;
    }

    public SkiRun(pl.jurkir.skiapi.dao.SkiRun skiRun) {
        this.id = skiRun.getId();
        this.length = skiRun.getLength();
        this.heightDifference = skiRun.getHeightDifference();
        this.skiRunType = skiRun.getType().get(0).getName();
        this.skiRunLevel = skiRun.getLevel().get(0).getName();
    }

    public SkiRun() {
    }
}
