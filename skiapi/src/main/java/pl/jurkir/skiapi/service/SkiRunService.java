package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.SkiRun;

import java.util.List;

public interface SkiRunService {

    SkiRun getSkiRun(Long id);

    Long updateSkiRun(SkiRun skiRun);

    Long addSkiRun(SkiRun skiRun);

    void deleteSkiRun(Long id);

    List<SkiRun> findAll();
}
