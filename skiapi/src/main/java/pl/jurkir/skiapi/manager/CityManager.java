package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.City;
import pl.jurkir.skiapi.repository.CityRepository;
import pl.jurkir.skiapi.service.CityService;

import java.util.List;

@Service
public class CityManager implements CityService {

    @Autowired
    CityRepository repository;

    @Override
    public City getCity(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<City> findAll() {
        return repository.findAll();
    }
}
