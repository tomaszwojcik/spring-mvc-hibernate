package pl.playbit.springhibernate.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table
public class Dog {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String name;

    @JoinColumn
    @ManyToOne
    private Person owner;

    public Dog(String name) {
        this.name = name;
    }

}
