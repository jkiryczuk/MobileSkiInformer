package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.County;
import pl.jurkir.skiapi.repository.CountyRepository;
import pl.jurkir.skiapi.service.CountyService;

import java.util.List;

@Service
public class CountyManager implements CountyService {

    @Autowired
    CountyRepository countyRepository;

    @Override
    public County getCounty(Long id) {
        return countyRepository.getOne(id);
    }

    @Override
    public Long updateCounty(County county) {
        County toUpdate = countyRepository.getOne(county.getId());
        toUpdate.setName(county.getName());
        return countyRepository.save(toUpdate).getId();
    }

    @Override
    public Long addCounty(County county) {
        return countyRepository.save(county).getId();
    }

    @Override
    public void deleteCounty(Long id) {
        countyRepository.deleteById(id);
    }

    @Override
    public List<County> findAll() {
        return countyRepository.findAll();
    }
}
