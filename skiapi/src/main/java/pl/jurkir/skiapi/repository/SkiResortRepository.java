package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.SkiResort;

@Repository
public interface SkiResortRepository extends JpaRepository<SkiResort, Long> {
}
