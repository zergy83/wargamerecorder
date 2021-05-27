package core.controllers;

import core.models.Partie;
import core.services.PartieServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "partie")
public class PartieControler {

    /**Logger for this class*/
    private static final Logger LOGGER = LoggerFactory.getLogger(PartieControler.class);

    @Autowired
    PartieServices partieServices;

    //Simple get Request
    @GetMapping("{id}")
    public Optional<Partie> findById(@PathVariable("id") int id) {
        return partieServices.findById(id);
    }

    @GetMapping("")
    public List<Partie> findAll(){
        LOGGER.info("Get all parties from server");
        return partieServices.findAll();
    }
}
