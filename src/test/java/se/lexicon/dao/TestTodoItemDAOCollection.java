package se.lexicon.dao;
import org.junit.jupiter.api.*;
import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestTodoItemDAOCollection {
    // Declare variables of class TodoItemDAOCollection and TodoItem
    private TodoItemDAOCollection myCollection;
    private Person p1;
    private Person p2;
    private TodoItem i1;
    private TodoItem i2;
    private TodoItem i3;

    @BeforeEach
    public void setup() {
        myCollection = new TodoItemDAOCollection();
        p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        p2 = new Person("Mora", "Nisse", "nisse@gmail.com");
        i1 = new TodoItem("Städa", "som fan", p1, "2024-04-25");
        i2 = new TodoItem("Tvätta", "som fan", p2, "2024-04-20");
        i3 = new TodoItem("Handla", "som fan", p1, "2024-04-20");
        myCollection.persist(i1);
        myCollection.persist(i2);
        myCollection.persist(i3);
    }

    @Test
    public void testPersist() {
        assertTrue(myCollection.findAll().contains(i1));
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
    public void testFindAllByDoneStatus() {
        i1.setDone(true);
        i2.setDone(true);
        i3.setDone(false);
        List <TodoItem> doneList = myCollection.findAllByDoneStatus(true);
        assertTrue(doneList.contains(i1));
        assertTrue(doneList.contains(i2));
        assertFalse(doneList.contains(i3));
    }

    @Test
    public void testFindByTitleContains() {
        TodoItem i4 = new TodoItem("Handla", "som fan", p1, "2024-04-20");
        myCollection.persist(i4);
        List <TodoItem> titleList = myCollection.findByTitleContains("Handla");
        assertTrue(titleList.contains(i3));
        assertTrue(titleList.contains(i4));
        assertFalse(titleList.contains(i1));
    }

    @Test
    public void testFindByPersonId() {
        List <TodoItem> personsList = myCollection.findByPersonId(1);
        assertTrue(personsList.contains(i1));
        assertTrue(personsList.contains(i3));
        assertFalse(personsList.contains(i2));
    }

    @Test
    public void testFindByDeadlineBefore() {
        List <TodoItem> deadlineList = myCollection.findByDeadlineBefore(LocalDate.parse("2024-04-21"));
        assertTrue(deadlineList.contains(i2));
        assertTrue(deadlineList.contains(i3));
        assertFalse(deadlineList.contains(i1));
    }

    @Test
    public void testFindByDeadlineAfter() {
        List <TodoItem> deadlineList = myCollection.findByDeadlineAfter(LocalDate.parse("2024-04-21"));
        assertTrue(deadlineList.contains(i1));
        assertFalse(deadlineList.contains(i2));
        assertFalse(deadlineList.contains(i3));
    }

    @Test
    public void testRemove() {
        myCollection.remove(i1);
        assertFalse(myCollection.findAll().contains(i1));
    }

}

