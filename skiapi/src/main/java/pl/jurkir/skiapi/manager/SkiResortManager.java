package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.SkiResort;
import pl.jurkir.skiapi.repository.SkiResortRepository;
import pl.jurkir.skiapi.service.SkiResortService;

import java.util.List;

@Service
public class SkiResortManager implements SkiResortService {

    @Autowired
    SkiResortRepository skiResortRepository;

    @Override
    public SkiResort getSkiResort(Long id) {
        return skiResortRepository.getOne(id);
    }

    @Override
    public Long updateSkiResort(SkiResort skiResort) {
        SkiResort toUpdate = skiResortRepository.getOne(skiResort.getId());
        toUpdate.setName(skiResort.getName());
        return skiResortRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSkiResort(SkiResort skiResort) {
        return skiResortRepository.save(skiResort).getId();
    }

    @Override
    public void deleteSkiResort(Long id) {
        skiResortRepository.deleteById(id);
    }

    @Override
    public List<SkiResort> findAll() {
        return skiResortRepository.findAll();
    }

    @Override
    public List<SkiResort> findByVoivodeship(Long voivodeshipid){
        return skiResortRepository.findSkiResortByVoivodeShip(voivodeshipid);
    }

    @Override
    public List<SkiResort> findSkiResortByCounties(Long countyId){
        return skiResortRepository.findSkiResortByCounties(countyId);
    }

    @Override
    public List<SkiResort> findSkiResortByBorough(Long boroughId){
        return skiResortRepository.findSkiResortByBorough(boroughId);
    }


}
