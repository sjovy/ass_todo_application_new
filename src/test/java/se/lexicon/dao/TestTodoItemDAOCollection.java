package se.lexicon.dao;
import org.junit.jupiter.api.*;
import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class TestTodoItemDAOCollection {
    private TodoItemDAOCollection todoItemList_dao;
    private Person p1;
    private Person p2;
    private TodoItem i1;
    private TodoItem i2;
    private TodoItem i3;

    @BeforeEach
    public void setup() {
        todoItemList_dao = new TodoItemDAOCollection();
        p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        p2 = new Person("Mora", "Nisse", "nisse@gmail.com");
        i1 = new TodoItem("Städa", "som fan", p1, "2024-04-25");
        i2 = new TodoItem("Tvätta", "som fan", p2, "2024-04-20");
        i3 = new TodoItem("Handla", "som fan", p1, "2024-04-20");
        todoItemList_dao.persist(i1);
        todoItemList_dao.persist(i2);
        todoItemList_dao.persist(i3);
    }

    @Test
    public void testPersist() {
        // Find all todoItems
        assertTrue(todoItemList_dao.findAll().contains(i1));
    }

    @Test
    public void testFindById() {
        int ID = i1.getId();
        // Find todoItem by its ID
        TodoItem foundTodoItem = todoItemList_dao.findById(ID);
        assertEquals(ID, foundTodoItem.getId());
    }

    @Test
    public void testFindByIdWrongId() {
        assertNull(todoItemList_dao.findById(9999));
    }

    @Test
    public void testFindAllByDoneStatus() {
        i1.setDone(true);
        i2.setDone(true);
        i3.setDone(false);

        // Find all todoItems with a certain done status
        List <TodoItem> testList = todoItemList_dao.findAllByDoneStatus(true);
        assertTrue(testList.contains(i1));
        assertTrue(testList.contains(i2));
        assertFalse(testList.contains(i3));
    }

    @Test
    public void testFindByTitleContains() {
        TodoItem i4 = new TodoItem("Handla", "som fan", p1, "2024-04-20");
        todoItemList_dao.persist(i4);

        // Find all todoItems with a certain title
        List <TodoItem> testList = todoItemList_dao.findByTitleContains("Handla");
        assertTrue(testList.contains(i3));
        assertTrue(testList.contains(i4));
        assertFalse(testList.contains(i1));
    }

    @Test
    public void testFindByPersonId() {

        // Find all todoItems with a certain creator's ID
        List <TodoItem> testList = todoItemList_dao.findByPersonId(p1.getPersonId());
        assertTrue(testList.contains(i1));
        assertTrue(testList.contains(i3));
        assertFalse(testList.contains(i2));

    }

    @Test
    public void testFindByDeadlineBefore() {
        LocalDate deadline = LocalDate.parse("2024-04-21");

        // Find all todoItems with deadline before a certain date
        List <TodoItem> testList = todoItemList_dao.findByDeadlineBefore(deadline);
        assertTrue(testList.contains(i2));
        assertTrue(testList.contains(i3));
        assertFalse(testList.contains(i1));
    }

    @Test
    public void testFindByDeadlineAfter() {
        LocalDate deadline = LocalDate.parse("2024-04-21");

        // Find all todoItems with deadline after a certain date
        List <TodoItem> testList = todoItemList_dao.findByDeadlineAfter(deadline);
        assertTrue(testList.contains(i1));
        assertFalse(testList.contains(i2));
        assertFalse(testList.contains(i3));
    }

    @Test
    public void testRemove() {
        todoItemList_dao.remove(i1);
        assertFalse(todoItemList_dao.findAll().contains(i1));
    }

}

