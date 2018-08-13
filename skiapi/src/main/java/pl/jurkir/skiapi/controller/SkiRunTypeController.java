package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.SkiRunType;
import pl.jurkir.skiapi.service.SkiRunTypeService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/skiruntype")
public class SkiRunTypeController {

    @Autowired
    SkiRunTypeService skiRunTypeService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SkiRunType get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.SkiRunType skiRunType = skiRunTypeService.getSkiRunType(id);
        return new SkiRunType(skiRunType);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        skiRunTypeService.deleteSkiRunType(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SkiRunType> findAll() {
        List<pl.jurkir.skiapi.dao.SkiRunType> skiRunTypes = skiRunTypeService.findAll();
        List<SkiRunType> skiRunTypeSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiRunType SkiRunTypeDaoObject : skiRunTypes) {
            skiRunTypeSdoList.add(new SkiRunType(SkiRunTypeDaoObject));
        }
        return skiRunTypeSdoList;
    }
}
