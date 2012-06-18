package pl.playbit.springhibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.playbit.springhibernate.dao.PersonDAO;
import pl.playbit.springhibernate.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    @Transactional
    public void addPerson(Person person) {
        personDAO.add(person);
    }

    @Override
    @Transactional
    public List<Person> getAllPersons() {
        return personDAO.getAllPersons();
    }

    @Override
    @Transactional
    public List<Person> getAllPersonsWithLastname(String lastname) {
        return personDAO.getAllPersonsWithLastname(lastname);
    }
}
