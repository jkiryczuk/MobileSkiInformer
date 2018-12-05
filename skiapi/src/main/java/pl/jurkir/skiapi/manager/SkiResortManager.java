package pl.jurkir.skiapi.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.jurkir.skiapi.dao.City;
import pl.jurkir.skiapi.dao.SkiResort;
import pl.jurkir.skiapi.dao.SkiRun;
import pl.jurkir.skiapi.repository.CityRepository;
import pl.jurkir.skiapi.repository.SkiResortRepository;
import pl.jurkir.skiapi.service.SkiResortService;


import java.util.ArrayList;
import java.util.List;

@Service
public class SkiResortManager implements SkiResortService {

    public static final int DISTANCE_IN_KM = 20;
    @Autowired
    SkiResortRepository skiResortRepository;

    @Autowired
    CityRepository cityRepository;

    @Override
    public SkiResort getSkiResort(Long id) {
        return skiResortRepository.getOne(id);
    }

    @Override
    public Long updateSkiResort(SkiResort skiResort) {
        SkiResort toUpdate = skiResortRepository.getOne(skiResort.getId());
        toUpdate.setName(skiResort.getName());
        return skiResortRepository.save(toUpdate).getId();
    }

    @Override
    public Long addSkiResort(SkiResort skiResort) {
        return skiResortRepository.save(skiResort).getId();
    }

    @Override
    public void deleteSkiResort(Long id) {
        skiResortRepository.deleteById(id);
    }

    @Override
    public List<SkiResort> findAll() {
        return skiResortRepository.findAll();
    }

    @Override
    public List<SkiResort> findByVoivodeship(Long voivodeshipid){
        return skiResortRepository.findSkiResortByVoivodeShip(voivodeshipid);
    }

    @Override
    public List<SkiResort> findSkiResortByCounties(Long countyId){
        return skiResortRepository.findSkiResortByCounties(countyId);
    }

    @Override
    public List<SkiResort> findSkiResortByBorough(Long boroughId){
        return skiResortRepository.findSkiResortByBorough(boroughId);
    }

    @Override
    public List<SkiResort> findClosesToId(Long cityId) {
        City city = cityRepository.getOne(cityId);
        List<SkiResort> resorts = skiResortRepository.findAll();
        List<SkiResort> closest = new ArrayList<>();
        for(SkiResort resort : resorts){
            if(DistanceCalculator.distanceTo(city,resort) <= DISTANCE_IN_KM){
                closest.add(resort);
            }
        }
        return closest;
    }

    public static class DistanceCalculator{
        public static double distanceTo(City city,
                                      SkiResort resort) {

            double latDiff  = Math.toRadians((resort.getLatitude() - city.getLat()));
            double lonDiff = Math.toRadians((resort.getLongitude() - city.getLng()));

            double radStartLat = Math.toRadians(city.getLat());
            double radEndLat   = Math.toRadians(resort.getLatitude());

            double a = hav(latDiff) + Math.cos(radStartLat) * Math.cos(radEndLat) * hav(lonDiff);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            return 6371 * c;
        }

        public static double hav(double difference ) {
            return Math.pow(Math.sin(difference / 2), 2);
        }
    }


}
