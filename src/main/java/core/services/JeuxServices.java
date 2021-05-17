package core.services;

import core.models.Jeux;
import core.repositories.JeuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class JeuxServices {
    // Load JPA Repository manager using Jeux Entity and JPA key word based persistence system
    @Autowired
    JeuxRepository jeuxRepository;

    public Optional<Jeux> findById(int id){
        return jeuxRepository.findById(id);
    }

    /**
     * find All Jeux in database
     * @return List of Jeux in database
     */
    public List<Jeux> findAll(){
        return  jeuxRepository.findAll();
    }
}
