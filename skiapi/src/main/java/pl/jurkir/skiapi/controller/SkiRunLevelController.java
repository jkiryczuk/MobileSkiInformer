package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.SkiRunLevel;
import pl.jurkir.skiapi.service.SkiRunLevelService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/skirunlevel")
public class SkiRunLevelController {

    @Autowired
    SkiRunLevelService skiRunLevelService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SkiRunLevel get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.SkiRunLevel skiRunLevel = skiRunLevelService.getSkiRunLevel(id);
        return new SkiRunLevel(skiRunLevel);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        skiRunLevelService.deleteSkiRunLevel(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SkiRunLevel> findAll() {
        List<pl.jurkir.skiapi.dao.SkiRunLevel> SkiRunLevels = skiRunLevelService.findAll();
        List<SkiRunLevel> skiRunLevelSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiRunLevel skiRunLevelDaoObject : SkiRunLevels) {
            skiRunLevelSdoList.add(new SkiRunLevel(skiRunLevelDaoObject));
        }
        return skiRunLevelSdoList;
    }
}
