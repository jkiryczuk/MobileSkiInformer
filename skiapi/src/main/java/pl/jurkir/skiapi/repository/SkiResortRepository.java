package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.SkiResort;

import java.util.ArrayList;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, Long> {
    //SQL
    @Query(value =
            "SELECT * FROM ski_resorts \n" +
            "INNER JOIN boroughs on ski_resorts.borough = boroughs.id\n" +
            "INNER JOIN counties on boroughs.county = counties.id\n" +
            "INNER JOIN voivodeships on counties.voivodeship = voivodeships.id\n" +
            "WHERE voivodeships.id = ?1", nativeQuery = true)
    ArrayList<SkiResort> findSkiResortByVoivodeShip(Long voivodeshipId);

    @Query(value =
            "SELECT * FROM ski_resorts \n" +
                    "INNER JOIN boroughs on ski_resorts.borough = boroughs.id\n" +
                    "INNER JOIN counties on boroughs.county = counties.id\n" +
                    "WHERE counties.id = ?1", nativeQuery = true)
    ArrayList<SkiResort> findSkiResortByCounties(Long countyId);
    //HQL
    @Query(value = "SELECT resort from SkiResort resort where resort.borough.id = ?1")
    ArrayList<SkiResort> findSkiResortByBorough(Long boroughId);

}
