package pl.jurkir.skiapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.jurkir.skiapi.sdo.Voivodeship;
import pl.jurkir.skiapi.service.VoivodeshipService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RestController
@RequestMapping("/api/voivodeship")
public class VoivodeshipController {

    @Autowired
    VoivodeshipService voivodeshipService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    Voivodeship get(@PathVariable("id") Long id) {
        pl.jurkir.skiapi.dao.Voivodeship voivodeship = voivodeshipService.getVoivodeship(id);
        return new Voivodeship(voivodeship);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id) {
        voivodeshipService.deleteVoivodeship(id);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Voivodeship> findAll() {
        List<pl.jurkir.skiapi.dao.Voivodeship> voivodeships = voivodeshipService.findAll();
        List<Voivodeship> voivodeshipSdoList = new ArrayList<>();
        for (pl.jurkir.skiapi.dao.Voivodeship voivodeshipDaoObject : voivodeships) {
            voivodeshipSdoList.add(new Voivodeship(voivodeshipDaoObject));
        }
        return voivodeshipSdoList;
    }
}
