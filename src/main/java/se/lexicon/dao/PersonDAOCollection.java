package se.lexicon.dao;

import se.lexicon.model.Person;
import java.util.ArrayList;
import java.util.List;

public class PersonDAOCollection implements PersonDAO {
    private List<Person> persons = new ArrayList<>();

    @Override
    public void persist(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(int personId) {
        for (Person person : persons) {
            if (person.getPersonId() == personId) {
                return person;
            }
        }
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        for (Person person : persons) {
            if (person.getEmail().equals(email)) {
                return person;
            }
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }

    @Override
    public void remove(Person person) {
        persons.remove(person);
    }

}
