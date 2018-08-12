package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.County;

import java.util.List;

public interface CountyService {

    County getCounty(Long id);

    Long updateCounty(County county);

    Long addCounty(County county);

    void deleteCounty(Long id);

    List<County> findAll();
}
