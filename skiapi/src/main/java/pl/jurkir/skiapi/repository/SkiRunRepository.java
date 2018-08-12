package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.SkiRun;

@Repository
public interface SkiRunRepository extends JpaRepository<SkiRun, Long> {
}
