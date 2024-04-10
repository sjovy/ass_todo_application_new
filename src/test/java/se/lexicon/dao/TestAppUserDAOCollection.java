package se.lexicon.dao;

import org.junit.jupiter.api.*;
import se.lexicon.model.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static se.lexicon.model.AppRole.ROLE_APP_ADMIN;
import static se.lexicon.model.AppRole.ROLE_APP_USER;

public class TestAppUserDAOCollection {
    AppUserDAOCollection myCollection;
    AppUser u1;

    @BeforeEach
    public void setup(){
        myCollection = new AppUserDAOCollection();
        u1 = new AppUser("Thomas", "1234", ROLE_APP_USER);
        myCollection.persist(u1);
    }
    @Test
    public void testPersist() {
        // Also find by username
        assertEquals("Thomas", myCollection.findByUsername("Thomas").getUsername());
    }

    @Test
    public void testNoUsernameEquals() {
        assertNotEquals("Lasse", myCollection.findByUsername("Thomas").getUsername());
    }

    @Test
    public void testFindAll() {
        AppUser u2 = new AppUser("Olle", "ABCD", ROLE_APP_ADMIN);

        myCollection.persist(u2);
        List<AppUser> allPersons = myCollection.findAll();

        assertEquals(2, allPersons.size());
        assertTrue(allPersons.contains(u1));
        assertTrue(allPersons.contains(u2));
    }

    @Test
    public void testRemove(){
        myCollection.remove(u1);

    }

}
