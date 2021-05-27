package core.models;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * Game model
 */
@Entity
@Table(name="jeux")
public class Jeux {
    @Id
    @GeneratedValue
    public  int id;
    @Cascade(value= CascadeType.ALL)
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

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
