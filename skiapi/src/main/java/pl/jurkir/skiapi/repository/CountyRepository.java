package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.County;
import pl.jurkir.skiapi.dao.Voivodeship;

import java.util.ArrayList;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {

    ArrayList<County> findCountiesByVoivodeship (Voivodeship voivodeship);
}
