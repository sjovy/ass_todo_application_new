package se.lexicon.dao;
import se.lexicon.model.Person;
import java.util.*;
import java.util.function.Predicate;

public class PersonDAOCollection implements PersonDAO {
    private List<Person> persons = new ArrayList<>();

    // Singleton instance
    private static PersonDAOCollection INSTANCE = null;

    // Private constructor
    private PersonDAOCollection() {}

    // Singleton method
    public static PersonDAOCollection getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PersonDAOCollection();
        }
        return INSTANCE;
    }

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
        // its also possible to break out the repeat stream to a separate method.
        // or even a separate utility class if it is used in multiple places.
        Optional<Person> person_op = persons.stream()
                                           .filter(emailMatch)
                                           .findFirst();

        return person_op.orElse(null);
    }

    @Override
    public List<Person> findAll() {
        return Collections.unmodifiableList(persons);
    }

    @Override
    public void remove(Person person) {
        persons.removeIf(p -> p.equals(person));
    }

}
