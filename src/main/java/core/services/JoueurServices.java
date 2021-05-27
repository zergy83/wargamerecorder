package core.services;

import core.models.Joueur;
import core.models.Partie;
import core.repositories.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Service of Joueur Class
 */
@Service
@Transactional
public class JoueurServices {

    // Load JPA Repository manager using Joueur Entity and JPA key word based persistence system
    @Autowired
    JoueurRepository joueurRepository;

    String sqlSelectAllPersons = "SELECT * FROM joueurs";
    String sqlGetAllPlayerFromGame = "select * from parties\n" +
            "inner join joueurs\n" +
            "on joueurs.id = parties.Joueur1 or joueurs.id = parties.Joueur2\n";
    String connectionUrl = "jdbc:mysql://localhost:3306/jeuxstats?serverTimezone=UTC";


    public List<Joueur> testJoueursTable(){
        List<Joueur> joueurs = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
                PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                long id = rs.getLong("ID");
                String name = rs.getString("Nom");
                int age = rs.getInt("age");

                    joueurs.add(getPlayer(name,age));
            }
        } catch (SQLException e) {
            System.out.println("cannot connect to database");
        }

        return  joueurs;
    }


    /**
     * Instanciate a player with data from sqlDatabase
     * @param name
     * @param age
     * @return
     */
    public Joueur getPlayer(String name, int age){
        Joueur joueur = new Joueur();
        joueur.setNom(name);
        joueur.setAge(age);
        System.out.println("Got a player" + joueur.toString());
        return  joueur;
    }

    /**
     * Get all players from a specific game
     * @param gameId
     */
    public List<Joueur> getAllPlayerFromGame(int gameId){
        List<Joueur> playerList = new ArrayList<>();
        try (
                Connection conn = DriverManager.getConnection(connectionUrl, "root", "root");
                PreparedStatement ps = conn.prepareStatement(sqlGetAllPlayerFromGame);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String name = rs.getString("Nom");
                int age = rs.getInt("age");
                Joueur joueur = new Joueur();
                joueur.setAge(age);
                joueur.setNom(name);
                playerList.add(joueur);
            }


        } catch (SQLException e) {
            System.out.println("cannot connect to database");
        }
        System.out.println("Voici les joueurs de la partie id n°" +  gameId);
        System.out.println(playerList);
        return  playerList;
    }

    /**
     * Get a game from sql Database
     * @param id
     * @param date
     * @return
     */
    public Partie getPartie(int id, LocalDate date){
        Partie partie = new Partie();
        partie.setId(id);
        partie.setDate(date);

        return partie;
    }



    // Spring Application Server Service

    /**
     * Find Joueur by Id in database using JPA repository keyword
     * @param id
     * @return
     */
    public Optional<Joueur> findJoueurById(int id){
        return joueurRepository.findById(id);
    }

    /**
     * @return List of all Joueurs in database
     */
    public List<Joueur> findAll(){
        return  joueurRepository.findAll();
    }

    /**
     * Persist all Joueur in a List
     * @param joueurList
     */
    public void addJoueurList(List<Joueur> joueurList){
        for (Joueur j : joueurList){
            joueurRepository.save(j);
        }
    }


    /**
     * Simple find by Id Jouer in persistance layer
     * @param id
     * @return
     */
    public Optional<Joueur> findById(int id){
        return joueurRepository.findById(id);
    }
}
