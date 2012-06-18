package pl.playbit.springhibernate.service;

import pl.playbit.springhibernate.model.Person;

import java.util.List;

public interface PersonService {

    void addPerson(Person person);

    List<Person> getAllPersons();

    List<Person> getAllPersonsWithLastname(String lastname);

}
