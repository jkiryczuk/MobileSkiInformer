package pl.jurkir.skiapi.service;

import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.Voivodeship;

import java.util.List;

@Service
public interface VoivodeshipService {
    Voivodeship getVoivodeship(Long id);
    Long updateVoivodeship(Voivodeship voivodeship);
    Long addVoivodeship(Voivodeship voivodeship);
    void deleteVoivodeship(Long id);
    List<Voivodeship> findAll();
}
