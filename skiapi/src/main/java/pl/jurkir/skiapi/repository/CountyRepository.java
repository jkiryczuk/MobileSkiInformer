package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.County;

@Repository
public interface CountyRepository extends JpaRepository<County, Long> {
}
