package se.lexicon.dao;

import se.lexicon.model.Person;

import java.util.List;

public interface PersonDAO {
    void persist(Person person);
    Person findById(int personId);
    Person findByEmail(String email);
    List<Person> findAll();
    void remove(Person person);
}
