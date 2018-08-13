package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.County;
import pl.jurkir.skiapi.service.CountyService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/county")
public class CountyController {
    @Autowired
    CountyService countyService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    County get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.County county = countyService.getCounty(id);
        return new County(county);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        countyService.deleteCounty(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<County> findAll() {
        List<pl.jurkir.skiapi.dao.County> counties = countyService.findAll();
        List<County> countySdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.County countyDaoObject : counties) {
            countySdoList.add(new County(countyDaoObject));
        }
        return countySdoList;
    }
}
