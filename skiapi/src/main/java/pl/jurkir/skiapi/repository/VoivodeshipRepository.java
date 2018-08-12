package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.Voivodeship;

@Repository
public interface VoivodeshipRepository extends JpaRepository<Voivodeship,Long> {
}
