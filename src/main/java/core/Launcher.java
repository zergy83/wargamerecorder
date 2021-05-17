package core;

import core.models.Joueur;
import core.models.Partie;
import core.services.JeuxServices;
import core.services.PartieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import core.services.JoueurServices;

import java.time.LocalDate;
import java.util.List;

/**
 * Main Server Application Launcher
 */
@SpringBootApplication
public class Launcher {
    /** Get beans of Spring Application Services*/
    @Autowired
    JoueurServices joueurServices;
    @Autowired
    JeuxServices jeuxServices;
    @Autowired
    PartieServices partieServices;


    public static void main(String[] args) {
        // Launch Spring Server
        SpringApplication.run(Launcher.class, args);
    }

    /**
     * Test Database before launching Server
     * @return
     */
    @Bean
    public CommandLineRunner test() {
        return (args) -> {
            System.out.println("WargameRecorder based Server Java is ready!");
            System.out.println(joueurServices.findAll());
            System.out.println(jeuxServices.findAll());
            System.out.println(partieServices.findAll());
        };
    }

    /**
     * Method to init entries in database for test purpose
     */
        private void initDatabase(){
            List<Joueur> joueurList = joueurServices.testJoueursTable();
            joueurServices.addJoueurList(joueurList);

            Partie partie = new Partie();
            partie.setDate(LocalDate.of(2021, 5, 8));
            partieServices.savePartie(partie);
        }


    /**
     * Use JDBC manual database query
     */
        private void directQuery(){
        JoueurServices ps = new JoueurServices();
        ps.testJoueursTable();
        ps.getAllPlayerFromGame(1);
        }
}
