package pl.playbit.springhibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private long id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @OneToMany(mappedBy = "owner")
    private List<Dog> dogs = new ArrayList<>();

    public void addDog(Dog dog) {
        dogs.add(dog);
        dog.setOwner(this);
    }

    public void removeDog(Dog dog) {
        dogs.remove(dog);
        dog.setOwner(null);
    }

}
