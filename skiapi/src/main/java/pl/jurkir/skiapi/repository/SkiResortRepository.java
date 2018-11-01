package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.SkiResort;

import java.util.ArrayList;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, Long> {

    @Query(value =
            "SELECT * FROM ski_resorts \n" +
            "INNER JOIN boroughs on ski_resorts.borough = boroughs.id\n" +
            "INNER JOIN counties on boroughs.county = counties.id\n" +
            "INNER JOIN voivodeships on counties.voivodeship = voivodeships.id\n" +
            "WHERE voivodeships.id = ?1", nativeQuery = true)
    ArrayList<SkiResort> findSkiResortByVoivodeShip(Long voivodeshipId);
}
