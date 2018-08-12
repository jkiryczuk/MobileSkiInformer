package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.SkiRunType;

import java.util.List;

public interface SkiRunTypeService {

    SkiRunType getSkiRunType(Long id);

    Long updateSkiRunType(SkiRunType skiRunType);

    Long addSkiRunType(SkiRunType skiRunType);

    void deleteSkiRunType(Long id);

    List<SkiRunType> findAll();
}
