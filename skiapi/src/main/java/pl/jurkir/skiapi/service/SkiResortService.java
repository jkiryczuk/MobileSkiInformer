package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.SkiResort;

import java.util.List;

public interface SkiResortService {

    SkiResort getSkiResort(Long id);

    Long updateSkiResort(SkiResort skiResort);

    Long addSkiResort(SkiResort skiResort);

    void deleteSkiResort(Long id);

    List<SkiResort> findAll();
}