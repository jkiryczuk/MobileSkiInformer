package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.SkiRunType;

@Repository
public interface SkiRunTypeRepository extends JpaRepository<SkiRunType, Long> {
}
