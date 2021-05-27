package core.services;

import core.models.Partie;
import core.repositories.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartieServices {
    // Load JPA Repository manager using Partie Entity and JPA key word based persistence system
    @Autowired
    PartieRepository partieRepository;


    /**
     * Find a "partie" in Persistance layer by its id
     * @param id
     * @return
     */
    public Optional<Partie> findById(int id){
        return  partieRepository.findById(id);
    }

    public List<Partie> findAll(){
        return partieRepository.findAll();
    }

    public void savePartie(Partie partie){
        partieRepository.save(partie);
    }
}
