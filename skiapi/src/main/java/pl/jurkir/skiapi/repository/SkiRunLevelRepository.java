package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.SkiRunLevel;

@Repository
public interface SkiRunLevelRepository extends JpaRepository<SkiRunLevel, Long> {
}
