package core.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Game model
 */
@Entity
@Table(name="partie")
public class Partie {
    @Id
    @GeneratedValue
    private int id;
    private LocalDate date;
    @Cascade(value= CascadeType.ALL)
    @OneToOne
    private Jeux jeux;
/*    private Joueur joueur1;
    private Joueur joueur2;
    private Joueur joueur3;
    private Joueur joueur4;
    private Joueur joueur5;
    private Joueur joueur6;*/

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public Jeux getJeux() {
        return jeux;
    }

    public void setJeux(Jeux jeux) {
        this.jeux = jeux;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }
}
