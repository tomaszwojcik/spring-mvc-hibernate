package pl.playbit.springhibernate.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.playbit.springhibernate.model.Person;

import java.util.List;

@Repository
public class PersonDAOImpl implements PersonDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addPerson(Person person) {
        sessionFactory.getCurrentSession().save(person);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Person getPerson(long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Person where id = :id");
        query.setParameter("id", id);
        return (Person) query.uniqueResult();
    }

    @Override
    public void removePerson(long id) {
        Person person = getPerson(id);
        sessionFactory.getCurrentSession().delete(person);
    }

    @Override
    public void updatePersonLastname(long id, String newLastname) {
        Person person = getPerson(id);
        person.setLastname(newLastname);
        sessionFactory.getCurrentSession().update(person);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersons() {
        return sessionFactory.getCurrentSession().createQuery("from Person").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Person> getAllPersonsWithLastname(String lastname) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Person where lastname = :lastname");
        query.setParameter("lastname", lastname);
        return query.list();
    }

}
