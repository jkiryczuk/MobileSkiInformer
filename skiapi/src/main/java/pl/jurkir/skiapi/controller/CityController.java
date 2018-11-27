package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.City;
import pl.jurkir.skiapi.service.CityService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/city")
public class CityController {

    @Autowired
    CityService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    City get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.City city = cityService.getCity(id);
        return new City(city);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<City> findAll() {
        List<pl.jurkir.skiapi.dao.City> cities = cityService.findAll();
        List<City> citiesSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.City cityDaoObj : cities) {
            citiesSdoList.add(new City(cityDaoObj));
        }
        return citiesSdoList;
    }


}
