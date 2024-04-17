package se.lexicon;

// import com.sun.tools.javac.comp.Todo;
import se.lexicon.dao.*;
import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

import static se.lexicon.model.AppRole.*;

public class App {

    public static void main(String[] args) {
        Person p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        System.out.println(p1);
        System.out.println(p1.hashCode());
        Person p2 = new Person("Lasse", "Ohlsson", "lo@home.se");
        System.out.println(p2);
        System.out.println(p2.hashCode());
        Person p3 = new Person("Olle", "Björk", "ob@yahoo.com");
        System.out.println(p3);
        System.out.println(p3.hashCode());
        System.out.println(p3.equals(p1));
        TodoItem i1 = new TodoItem("Städa", "som fan", p1, "2024-04-10");
        System.out.println(i1);
        i1.setDone(true);
        System.out.println(i1);

        TodoItemTask t1 = new TodoItemTask(p2, i1);
        System.out.println(t1);
        TodoItemTask t2 = new TodoItemTask(p3, i1);
        System.out.println(t2);
        System.out.println(t2.equals(t1));

        AppUser u1 = new AppUser("Thomas", "1234", ROLE_APP_USER);
        System.out.println(u1);
        System.out.println(u1.hashCode());
        AppUser u2 = new AppUser("Olle", "ABCD", ROLE_APP_ADMIN);

        // This is not a list, but an AppUserDAOCollection object,
        // containing a list and methods to manipulate it.
        AppUserDAO appUserList = new AppUserDAOCollection();

        appUserList.persist(u1);
        AppUser foundUser = appUserList.findByUsername("Thomas");
        System.out.println(foundUser);

        appUserList.persist(u2);
        List<AppUser> allUsers = appUserList.findAll();
        for (AppUser user : allUsers) {
            System.out.println(user);
        }
        // appUserList.remove(u1);

        PersonDAO personList = new PersonDAOCollection();

        personList.persist(p1);
        Person foundPerson = personList.findById(1);
        System.out.println(foundPerson);

        personList.persist(p2);

        List<Person> allPersons = personList.findAll();
        for (Person person : allPersons) {
            System.out.println(person);
        }

        TodoItemDAO todoItemList = new TodoItemDAOCollection();
        todoItemList.persist(i1);
        TodoItem foundTodoItem = todoItemList.findById(i1.getId());
        System.out.println(foundTodoItem);
        TodoItem i2 = new TodoItem("Tvätta", "som fan", p2, "2024-04-20");
        TodoItem i3 = new TodoItem("Handla", "som fan", p1, "2024-04-20");
        todoItemList.persist(i2);
        todoItemList.persist(i3);

        List <TodoItem> foundOnDoneItems = todoItemList.findAllByDoneStatus(false);
        for (TodoItem todoItem : foundOnDoneItems) {
            System.out.println(todoItem);
        }

        List <TodoItem> foundOnTitleItems = todoItemList.findByTitleContains("Tvätta");
        for (TodoItem todoItem : foundOnTitleItems) {
            System.out.println(todoItem);
        }

        List <TodoItem> foundOnPersonId = todoItemList.findByPersonId(p2.getPersonId());
        for (TodoItem todoItem : foundOnPersonId) {
            System.out.println(todoItem);
        }

        List <TodoItem> foundOnDeadline = todoItemList.findByDeadlineBefore(LocalDate.parse("2024-04-21"));
        for (TodoItem todoItem : foundOnDeadline) {
            System.out.println(todoItem);
        }

        TodoItemTaskDAO todoItemTaskList = new TodoItemTaskDAOCollection();
        TodoItemTask t11 = new TodoItemTask(p1, i1);
        TodoItemTask t12 = new TodoItemTask(p1, i2);
        TodoItemTask t21 = new TodoItemTask(p2, i1);
        TodoItemTask t22 = new TodoItemTask(p2, i2);

        todoItemTaskList.persist(t11);
        todoItemTaskList.persist(t12);
        todoItemTaskList.persist(t21);
        todoItemTaskList.persist(t22);

        List<TodoItemTask> foundByAssignedStatus = todoItemTaskList.findByAssignedStatus(true);
        for (TodoItemTask todoItemTask : foundByAssignedStatus) {
            if (todoItemTask == null){
                throw new IllegalArgumentException("No assignees found.");
            }
            System.out.println(todoItemTask);
        }
        
        List<TodoItemTask> foundByPersonId = todoItemTaskList.findByPersonId(p1.getPersonId());
        for (TodoItemTask todoItemTask : foundByPersonId) {
            System.out.println(todoItemTask);
        }

        /*Predicate<TodoItem> filterByTitle = todoItem -> todoItem.getTitle().contains("Task1");
        Predicate<TodoItem> filterById = todoItem -> todoItem.getId() == 1;
        todoItemDao.find(filterById);*/

    }
}
