package core.repositories;

import core.models.Partie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository Use for Partie Class
 * see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
 */
public interface PartieRepository extends JpaRepository<Partie, Integer> {

}
