package pl.playbit.springhibernate.dao;

import pl.playbit.springhibernate.model.Dog;
import pl.playbit.springhibernate.model.Person;

public interface DogDAO {

    void addDog(String name, Person owner);

    void saveDog(Dog dog);

    void removeDog(long id);
}
