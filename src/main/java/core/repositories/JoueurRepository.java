package core.repositories;
import core.models.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JpaRepository Use for Joueur Class
 * see https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#reference
 */
public interface JoueurRepository extends JpaRepository<Joueur, Integer> {
}
