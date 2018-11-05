package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.Borough;
import pl.jurkir.skiapi.repository.BoroughRepository;
import pl.jurkir.skiapi.service.BoroughService;

import java.util.List;

@Service
public class BoroughManager implements BoroughService {

    @Autowired
    BoroughRepository boroughRepository;

    @Override
    public Borough getBorough(Long id) {
        return boroughRepository.getOne(id);
    }

    @Override
    public Long updateBorough(Borough borough) {
        Borough toUpdate = boroughRepository.getOne(borough.getId());
        toUpdate.setName(borough.getName());
        return boroughRepository.save(toUpdate).getId();
    }

    @Override
    public Long addBorough(Borough borough) {
        return boroughRepository.save(borough).getId();
    }

    @Override
    public void deleteBorough(Long id) {
        boroughRepository.deleteById(id);
    }

    @Override
    public List<Borough> findAll() {
        return boroughRepository.findAll();
    }

    @Override
    public List<Borough> findBoroughByCountyId(Long countyId) {
        return  boroughRepository.findBoroughByCountyId(countyId);
    }
}
