package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.SkiRunLevel;

import java.util.List;

public interface SkiRunLevelService {

    SkiRunLevel getSkiRunLevel(Long id);

    Long updateSkiRunLevel(SkiRunLevel skiRunLevel);

    Long addSkiRunLevel(SkiRunLevel skiRunLevel);

    void deleteSkiRunLevel(Long id);

    List<SkiRunLevel> findAll();
}
