package se.lexicon.dao;
import se.lexicon.model.Person;
import java.util.*;
import java.util.function.Predicate;

public class PersonDAOCollection implements PersonDAO {
    private List<Person> persons = new ArrayList<>();

    @Override
    public void persist(Person person) {
        persons.add(person);
    }

    @Override
    public Person findById(int personId) {
        // Requires no import of predicate library.
        // Lambda is better than :: because of the risk for null.
        Optional<Person> Person_op = persons.stream()
                                                 .filter(person -> person.getPersonId() == personId)
                                                 .findFirst();

        return Person_op.orElse(null);
    }

    @Override
    public Person findByEmail(String email) {
        // requires import of Predicate library.
        // .orElse(null) - a method from Optional - is required to return null if not found.
        Predicate<Person> emailMatch = person -> person.getEmail().equals(email);
        Optional<Person> personOp = persons.stream()
                                           .filter(emailMatch)
                                           .findFirst();

        return personOp.orElse(null);
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
