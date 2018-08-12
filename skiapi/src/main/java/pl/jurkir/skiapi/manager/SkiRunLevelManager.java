package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.SkiRunLevel;
import pl.jurkir.skiapi.repository.SkiRunLevelRepository;
import pl.jurkir.skiapi.service.SkiRunLevelService;

import java.util.List;

@Service
public class SkiRunLevelManager implements SkiRunLevelService {

    @Autowired
    SkiRunLevelRepository skiRunLevelRepository;

    @Override
    public SkiRunLevel getSkiRunLevel(Long id) {
        return skiRunLevelRepository.getOne(id);
    }

    @Override
    public Long updateSkiRunLevel(SkiRunLevel skiRunLevel) {
        SkiRunLevel toUpdate = skiRunLevelRepository.getOne(skiRunLevel.getId());
        toUpdate.setName(skiRunLevel.getName());
        return skiRunLevelRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSkiRunLevel(SkiRunLevel skiRunLevel) {
        return skiRunLevelRepository.save(skiRunLevel).getId();
    }

    @Override
    public void deleteSkiRunLevel(Long id) {
        skiRunLevelRepository.deleteById(id);
    }

    @Override
    public List<SkiRunLevel> findAll() {
        return skiRunLevelRepository.findAll();
    }
}
