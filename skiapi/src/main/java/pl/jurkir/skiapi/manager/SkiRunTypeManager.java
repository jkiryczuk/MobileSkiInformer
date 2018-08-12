package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.SkiRunType;
import pl.jurkir.skiapi.repository.SkiRunTypeRepository;
import pl.jurkir.skiapi.service.SkiRunTypeService;

import java.util.List;

@Service
public class SkiRunTypeManager implements SkiRunTypeService {

    @Autowired
    SkiRunTypeRepository skiRunTypeRepository;

    @Override
    public SkiRunType getSkiRunType(Long id) {
        return skiRunTypeRepository.getOne(id);
    }

    @Override
    public Long updateSkiRunType(SkiRunType skiRunType) {
        SkiRunType toUpdate = skiRunTypeRepository.getOne(skiRunType.getId());
        toUpdate.setName(skiRunType.getName());
        return skiRunTypeRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSkiRunType(SkiRunType skiRunType) {
        return skiRunTypeRepository.save(skiRunType).getId();
    }

    @Override
    public void deleteSkiRunType(Long id) {
        skiRunTypeRepository.deleteById(id);
    }

    @Override
    public List<SkiRunType> findAll() {
        return skiRunTypeRepository.findAll();
    }
}
