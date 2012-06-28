package pl.playbit.springhibernate.service;

import pl.playbit.springhibernate.model.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);

    Person getPerson(long id);

    void deletePerson(long id);

    void updatePersonLastname(long id, String newLastname);

    List<Person> getAllPersons();

    List<Person> getAllPersonsWithLastname(String lastname);

}
