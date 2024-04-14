package se.lexicon.dao;
import org.junit.jupiter.api.*;
import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestTodoItemTaskDAOCollection {
    private TodoItemTaskDAOCollection myCollection;
    private Person p1;
    private Person p2;
    private TodoItem i1;
    private TodoItem i2;
    private TodoItemTask t11;
    private TodoItemTask t12;
    private TodoItemTask t21;
    private TodoItemTask t22;

    @BeforeEach
    public void setup() {
        myCollection = new TodoItemTaskDAOCollection();
        p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        p2 = new Person("Mora", "Nisse", "nisse@gmail.com");
        i1 = new TodoItem("Städa", "som fan", p1, "2024-04-25");
        i2 = new TodoItem("Tvätta", "som fan", p2, "2024-04-20");
        t11 = new TodoItemTask(p1, i1);
        t12 = new TodoItemTask(p1, i2);
        t21 = new TodoItemTask(p2, i1);
        t22 = new TodoItemTask(p2, i2);
        myCollection.persist(t11);
        myCollection.persist(t12);
        myCollection.persist(t21);
        myCollection.persist(t22);
    }

    @Test
    public void testPersist() {
        assertTrue(myCollection.findAll().contains(t11));
    }

    @Test
    public void testFindById() {
        int ID = i1.getId();
        assertEquals(ID, (myCollection.findById(ID)).getId());
    }

    @Test
    public void testFindByIdWrongId() {
        int hittepaId = 9999;
        assertNull(myCollection.findById(9999));
    }

    @Test
    public void testFindAll() {
        assertEquals(4, myCollection.findAll().size());
        List<TodoItemTask> allTasks = myCollection.findAll();
        assertTrue(allTasks.contains(t11));
        assertTrue(allTasks.contains(t12));
        assertTrue(allTasks.contains(t21));
        assertTrue(allTasks.contains(t22));
    }






    @Test
    public void testRemove() {
        myCollection.remove(t11);
        assertFalse(myCollection.findAll().contains(t11));
    }

}
