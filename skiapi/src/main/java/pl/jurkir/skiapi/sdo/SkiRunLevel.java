package pl.jurkir.skiapi.sdo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SkiRunLevel {

    private Long id;
    private String name;

    public SkiRunLevel(pl.jurkir.skiapi.dao.SkiRunLevel skiRunLevel) {
        this.id = skiRunLevel.getId();
        this.name = skiRunLevel.getName();
    }
}

