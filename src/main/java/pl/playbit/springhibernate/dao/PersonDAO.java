package pl.playbit.springhibernate.dao;

import pl.playbit.springhibernate.model.Person;

import java.util.List;

public interface PersonDAO {

    void add(Person person);

    List<Person> getAllPersons();

    List<Person> getAllPersonsWithLastname(String lastname);
}
