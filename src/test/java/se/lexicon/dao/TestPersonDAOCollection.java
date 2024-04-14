package se.lexicon.dao;

import org.junit.jupiter.api.*;
import se.lexicon.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestPersonDAOCollection {
    // Declare variables of class PersonDAOCollection and Person
    private PersonDAOCollection myCollection;
    private Person p1;
    private TodoItem i1;

    @BeforeEach
    public void setup() {
        // Instantiate the objects
        myCollection = new PersonDAOCollection();
        p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        myCollection.persist(p1);
    }

    @Test
    public void testPersist() {
        assertTrue(myCollection.findAll().contains(p1));
    }

    @Test
    public void testFindById() {
        int ID = p1.getPersonId();
        assertEquals(ID, (myCollection.findById(ID)).getPersonId());
    }

    @Test
    public void testFindByIdWrongId() {
        int hittepaId = 9999;
        assertNull(myCollection.findById(hittepaId));
    }

    @Test
    public void testFindByEmail() {
        String email = p1.getEmail();
        assertEquals(email, (myCollection.findByEmail(email)).getEmail());
    }

    @Test
    public void testFindByEmailNonExistingEmail() {
        String hittepaEmail = "knut@hittepå.no";
        assertNull(myCollection.findByEmail(hittepaEmail));
    }

    @Test
    public void testFindAll() {
    Person p2 = new Person("Lasse", "Ohlsson", "lo@home.se");
    Person p3 = new Person("Olle", "Björk", "ob@yahoo.com");
    myCollection.persist(p2);
    myCollection.persist(p3);
    List<Person> allPersons = myCollection.findAll();

    assertEquals(3,allPersons .size());
    assertTrue(allPersons.contains(p1));
    assertTrue(allPersons.contains(p2));
    assertTrue(allPersons.contains(p3));
    }

    @Test
    public void testRemove() {
        myCollection.remove(p1);
        assertFalse(myCollection.findAll().contains(p1));
    }
}
