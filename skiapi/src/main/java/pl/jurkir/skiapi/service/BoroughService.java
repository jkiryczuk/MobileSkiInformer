package pl.jurkir.skiapi.service;

import pl.jurkir.skiapi.dao.Borough;

import java.util.List;

public interface BoroughService {

    Borough getBorough(Long id);

    Long updateBorough(Borough Borough);

    Long addBorough(Borough Borough);

    void deleteBorough(Long id);

    List<Borough> findAll();

    List<Borough> findBoroughByCountyId(Long countyId);


}
