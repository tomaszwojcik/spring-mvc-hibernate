package pl.playbit.springhibernate.model;

import lombok.Data;

import javax.persistence.*;

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
}
