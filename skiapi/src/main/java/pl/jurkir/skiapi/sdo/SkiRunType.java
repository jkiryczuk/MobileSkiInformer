package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkiRunType {

    private Long id;
    private String name;

    public SkiRunType(pl.jurkir.skiapi.dao.SkiRunType skiRunType) {
        this.id = skiRunType.getId();
        this.name = skiRunType.getName();
    }
}
