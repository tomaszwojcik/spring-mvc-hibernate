package pl.playbit.springhibernate.dao;

import pl.playbit.springhibernate.model.Person;

import java.util.List;

public interface PersonDAO {

    void addPerson(Person person);

    Person getPerson(long id);

    void removePerson(long id);

    void updatePersonLastname(long id, String newLastname);

    List<Person> getAllPersons();

    List<Person> getAllPersonsWithLastname(String lastname);

}
