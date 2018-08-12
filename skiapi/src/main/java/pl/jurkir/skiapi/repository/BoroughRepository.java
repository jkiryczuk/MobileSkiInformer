package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.Borough;

@Repository
public interface BoroughRepository extends JpaRepository<Borough, Long> {
}
