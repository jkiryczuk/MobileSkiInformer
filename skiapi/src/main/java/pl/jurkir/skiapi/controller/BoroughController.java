package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.Borough;
import pl.jurkir.skiapi.service.BoroughService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/borough")
public class BoroughController {

    @Autowired
    BoroughService boroughService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Borough get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.Borough borough = boroughService.getBorough(id);
        return new Borough(borough);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        boroughService.deleteBorough(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Borough> findAll() {
        List<pl.jurkir.skiapi.dao.Borough> boroughs = boroughService.findAll();
        List<Borough> boroughSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.Borough boroughDaoObject : boroughs) {
            boroughSdoList.add(new Borough(boroughDaoObject));
        }
        return boroughSdoList;
    }
}
