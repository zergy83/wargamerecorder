package webservice.controllers;

import core.models.Partie;
import core.services.PartieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "Partie")
public class PartieController {

    @Autowired
    PartieServices partieServices;

    //Simple get Request
    @GetMapping("{id}")
    public Optional<Partie> findById(@PathVariable("id") int id) {
        return partieServices.findById(id);
    }

    @GetMapping("")
    public List<Partie> findAll(){
        return partieServices.findAll();
    }

}
