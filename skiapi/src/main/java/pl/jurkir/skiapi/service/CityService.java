package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.City;

import java.util.List;

public interface CityService {

    City getCity(Long id);

    List<City> findAll();
}
