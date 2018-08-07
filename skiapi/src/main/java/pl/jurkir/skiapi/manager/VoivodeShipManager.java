package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import pl.jurkir.skiapi.dao.Voivodeship;
import pl.jurkir.skiapi.repository.VoivodeshipRepository;
import pl.jurkir.skiapi.service.VoivodeshipService;

import java.util.List;

public class VoivodeShipManager implements VoivodeshipService {

    @Autowired
    VoivodeshipRepository voivodeshipRepository;

    @Override
    public Voivodeship getVoivodeship(Long id) {
        return voivodeshipRepository.getOne(id);
    }

    @Override
    public Long updateVoivodeship(Voivodeship voivodeship) {
        Voivodeship toUpdate = voivodeshipRepository.getOne(voivodeship.getId());
        toUpdate.setName(voivodeship.getName());
        return voivodeshipRepository.save(toUpdate).getId();
    }

    @Override
    public Long addVoivodeship(Voivodeship voivodeship) {
        return voivodeshipRepository.save(voivodeship).getId();
    }

    @Override
    public void deleteVoivodeship(Long id) {
        voivodeshipRepository.deleteById(id);
    }

    @Override
    public List<Voivodeship> findAll() {
        return voivodeshipRepository.findAll();
    }
}
