package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.SkiResort;
import pl.jurkir.skiapi.service.SkiResortService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/skiresort")
public class SkiResortController {

    @Autowired
    SkiResortService skiResortService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SkiResort get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.SkiResort skiResort = skiResortService.getSkiResort(id);
        return new SkiResort(skiResort);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        skiResortService.deleteSkiResort(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SkiResort> findAll() {
        List<pl.jurkir.skiapi.dao.SkiResort> skiResorts = skiResortService.findAll();
        List<SkiResort> skiResortSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiResort skiResortDaoObject : skiResorts) {
            skiResortSdoList.add(new SkiResort(skiResortDaoObject));
        }
        return skiResortSdoList;
    }

    @RequestMapping(value = "/by/voivodeship/{id}", method = RequestMethod.GET)
    public List<SkiResort> findByVoivodeShip(@PathVariable("id") Long id) {
        List<pl.jurkir.skiapi.dao.SkiResort> resorts = skiResortService.findByVoivodeship(id);
        List<SkiResort> resortList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiResort skiResortDaoObject : resorts) {
            resortList.add(new SkiResort(skiResortDaoObject));
        }
        return resortList;
    }

    @RequestMapping(value = "/by/county/{id}", method = RequestMethod.GET)
    public List<SkiResort> findSkiResortByCounties(@PathVariable("id") Long id) {
        List<pl.jurkir.skiapi.dao.SkiResort> resorts = skiResortService.findSkiResortByCounties(id);
        List<SkiResort> resortList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiResort skiResortDaoObject : resorts) {
            resortList.add(new SkiResort(skiResortDaoObject));
        }
        return resortList;
    }

    @RequestMapping(value = "/by/borough/{id}", method = RequestMethod.GET)
    public List<SkiResort> findSkiResortByBorough(@PathVariable("id") Long id) {
        List<pl.jurkir.skiapi.dao.SkiResort> resorts = skiResortService.findSkiResortByBorough(id);
        List<SkiResort> resortList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiResort skiResortDaoObject : resorts) {
            resortList.add(new SkiResort(skiResortDaoObject));
        }
        return resortList;
    }

    @RequestMapping(value = "/closest/{id}")
    public List<SkiResort> findClosestResortsToCities(@PathVariable("id") Long cityId) {
        List<pl.jurkir.skiapi.dao.SkiResort> resorts = skiResortService.findClosesToId(cityId);
        List<SkiResort> resortList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiResort skiResortDaoObject : resorts) {
            resortList.add(new SkiResort(skiResortDaoObject));
        }
        return resortList;
    }
}
