package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.Voivodeship;

import java.util.List;

public interface VoivodeshipService {

    Voivodeship getVoivodeship(Long id);

    Long updateVoivodeship(Voivodeship voivodeship);

    Long addVoivodeship(Voivodeship voivodeship);

    void deleteVoivodeship(Long id);

    List<Voivodeship> findAll();
}
