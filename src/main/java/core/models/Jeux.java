package core.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

/**
 * Game model
 */
@Entity
public class Jeux {
    @Id
    @GeneratedValue
    public  int id;
    private String nom;
    private int age;
    private LocalDate date;
    private String brand;

    @Override
    public String toString() {
        return "Jeux{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", brand='" + brand + '\'' +
                '}';
    }
}
