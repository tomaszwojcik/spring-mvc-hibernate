package pl.playbit.springhibernate.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.playbit.springhibernate.model.Dog;
import pl.playbit.springhibernate.model.Person;

@Repository
public class DogDAOImpl implements DogDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDog(String name, Person owner) {
        Dog dog = new Dog();
        dog.setName(name);
        dog.setOwner(owner);
        sessionFactory.getCurrentSession().save(dog);
    }

    @Override
    public void saveDog(Dog dog) {
        sessionFactory.getCurrentSession().save(dog);
    }

    @Override
    public void removeDog(long id) {
        Query query = sessionFactory.getCurrentSession().createQuery("from Dog where id = :id");
        query.setParameter("id", id);
        Dog dog = (Dog) query.uniqueResult();
        if (dog != null) {
            sessionFactory.getCurrentSession().delete(dog);
        }
    }
}
