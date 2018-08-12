package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.SkiRun;
import pl.jurkir.skiapi.repository.SkiRunRepository;
import pl.jurkir.skiapi.service.SkiRunService;

import java.util.List;

@Service
public class SkiRunManager implements SkiRunService {

    @Autowired
    SkiRunRepository skiRunRepository;

    @Override
    public SkiRun getSkiRun(Long id) {
        return skiRunRepository.getOne(id);
    }

    @Override
    public Long updateSkiRun(SkiRun skiRun) {
        SkiRun toUpdate = skiRunRepository.getOne(skiRun.getId());
        toUpdate.setLength(skiRun.getLength());
        return skiRunRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSkiRun(SkiRun skiRun) {
        return skiRunRepository.save(skiRun).getId();
    }

    @Override
    public void deleteSkiRun(Long id) {
        skiRunRepository.deleteById(id);
    }

    @Override
    public List<SkiRun> findAll() {
        return skiRunRepository.findAll();
    }
}
