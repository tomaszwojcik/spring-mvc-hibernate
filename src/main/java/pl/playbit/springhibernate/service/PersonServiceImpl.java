package pl.playbit.springhibernate.service;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.playbit.springhibernate.dao.DogDAO;
import pl.playbit.springhibernate.dao.PersonDAO;
import pl.playbit.springhibernate.model.Dog;
import pl.playbit.springhibernate.model.Person;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDAO personDAO;

    @Autowired
    private DogDAO dogDAO;

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void addPerson(Person person) {
        Dog dogs[] = { new Dog("Fafik"), new Dog("Sidi") };
        for (Dog dog : dogs) {
            dogDAO.saveDog(dog);
            person.addDog(dog);
        }
        personDAO.addPerson(person);
    }

    @Override
    @Transactional
    public Person getPerson(long id) {
        return personDAO.getPerson(id);
    }

    @Override
    @Transactional
    public void deletePerson(long id) {
        personDAO.removePerson(id);
    }

    @Override
    @Transactional
    public void updatePersonLastname(long id, String newLastname) {
        personDAO.updatePersonLastname(id, newLastname);
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
