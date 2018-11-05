package pl.jurkir.skiapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.jurkir.skiapi.dao.Borough;

import java.util.List;

@Repository
public interface BoroughRepository extends JpaRepository<Borough, Long> {

    @Query(value = "SELECT boroughs.id, " +
            "boroughs.name, boroughs.county " +
            "FROM ski_slopes_informer.boroughs, ski_slopes_informer.counties  where ski_slopes_informer.boroughs.county = ski_slopes_informer.counties.id \n" +
            "and counties.id = ?1" ,nativeQuery = true)
    List<Borough> findBoroughByCountyId(Long countyId);


}
