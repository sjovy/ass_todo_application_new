package se.lexicon.dao;
import org.junit.jupiter.api.*;
import se.lexicon.model.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestTodoItemTaskDAOCollection {
    private TodoItemTaskDAOCollection todoItemTaskList_dao;
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
        todoItemTaskList_dao = new TodoItemTaskDAOCollection();
        p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        p2 = new Person("Mora", "Nisse", "nisse@gmail.com");
        i1 = new TodoItem("Städa", "som fan", p1, "2024-04-25");
        i2 = new TodoItem("Tvätta", "som fan", p2, "2024-04-20");
        t11 = new TodoItemTask(p1, i1);
        t12 = new TodoItemTask(p1, i2);
        t21 = new TodoItemTask(p2, i1);
        t22 = new TodoItemTask(p2, i2);
        todoItemTaskList_dao.persist(t11);
        todoItemTaskList_dao.persist(t12);
        todoItemTaskList_dao.persist(t21);
        todoItemTaskList_dao.persist(t22);
    }

    @Test
    public void testPersist() {
        assertTrue(todoItemTaskList_dao.findAll().contains(t11));
    }

    /*@Test
    public void testFindById() {
        int ID = i1.getId();
        assertEquals(ID, (todoItemTaskList_dao.findById(ID)));
    }*/

    @Test
    public void testFindByIdWrongId() {
        assertNull(todoItemTaskList_dao.findById(9999));
    }

    @Test
    public void testFindAll() {
        assertEquals(4, todoItemTaskList_dao.findAll().size());
        List<TodoItemTask> allTasks = todoItemTaskList_dao.findAll();
        assertTrue(allTasks.contains(t11));
        assertTrue(allTasks.contains(t12));
        assertTrue(allTasks.contains(t21));
        assertTrue(allTasks.contains(t22));
    }

    @Test
    public void testRemove() {
        todoItemTaskList_dao.remove(t11);
        assertFalse(todoItemTaskList_dao.findAll().contains(t11));
    }

}
