package webservice.controllers;

import core.models.Joueur;
import core.services.JoueurServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="joueur")
public class JoueurControlleur {

    @Autowired
    JoueurServices joueurServices;

    @GetMapping("/{id}")
    public Optional<Joueur> findById(@PathVariable("id") int id) {
        return joueurServices.findById(id);
    }

    @GetMapping("")
    public List<Joueur> findAll(){
        return joueurServices.findAll();
    }


}
