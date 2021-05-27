package core;

import core.models.Jeux;
import core.models.Joueur;
import core.models.Partie;
import core.services.JeuxServices;
import core.services.JoueurServices;
import core.services.PartieServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDate;
import java.util.List;

/**
 * Main Server Application Launcher
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "core.repositories")
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

           // initDatabase();
           // testCascadePersistance();
            System.out.println(joueurServices.findAll());
            System.out.println(jeuxServices.findAll());
            System.out.println(partieServices.findAll());
        };
    }

    /**
     * Method to init some entries in database for test purpose
     */
        private void initDatabase(){
            System.out.println("Database test initiate");
            List<Joueur> joueurList = joueurServices.testJoueursTable();
            joueurServices.addJoueurList(joueurList);

            Partie partie = new Partie();
            partie.setDate(LocalDate.of(2021, 5, 21));
            Jeux jeu1 = new Jeux();
            jeu1.setNom("warhammer");
            partieServices.savePartie(partie);
        }

    /**
     * Instructions to test Cascade persistance Partie/Jeux
     */
        private void testCascadePersistance(){
            Joueur pierre = new Joueur();
            pierre.setAge(25);

            Partie superPartie = new Partie();
            Jeux mars = new Jeux();
            mars.setNom("Mars Code Aurora");
            superPartie.setJeux(mars);

            partieServices.savePartie(superPartie);
        }


    /**
     * Use JDBC manual database query
     */
        private void directQuery(){
        JoueurServices ps = new JoueurServices();
        ps.testJoueursTable();
        ps.getAllPlayerFromGame(1);
        }


    /**
     * Handles cross request from specific localhost, required for request on same machine
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "UPDATE", "DELETE", "OPTIONS")
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }
}
