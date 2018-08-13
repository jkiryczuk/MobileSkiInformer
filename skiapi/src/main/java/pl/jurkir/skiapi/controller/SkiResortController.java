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
}
