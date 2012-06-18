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
    public void add(Person person) {
        sessionFactory.getCurrentSession().save(person);
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
