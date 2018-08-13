package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.SkiRun;
import pl.jurkir.skiapi.service.SkiRunService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/skirun")
public class SkiRunController {
    @Autowired
    SkiRunService skiRunService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    SkiRun get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.SkiRun SkiRun = skiRunService.getSkiRun(id);
        return new SkiRun(SkiRun);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        skiRunService.deleteSkiRun(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<SkiRun> findAll() {
        List<pl.jurkir.skiapi.dao.SkiRun> skiRuns = skiRunService.findAll();
        List<SkiRun> skiRunSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.SkiRun skiRunDaoObject : skiRuns) {
            skiRunSdoList.add(new SkiRun(skiRunDaoObject));
        }
        return skiRunSdoList;
    }
}
