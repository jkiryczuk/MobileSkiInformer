package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.jurkir.skiapi.dao.Voivodeship;

public interface VoivodeshipRepository extends JpaRepository<Voivodeship,Long> {
}
