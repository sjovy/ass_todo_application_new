package se.lexicon;

import se.lexicon.dao.*;
import se.lexicon.model.*;
import java.util.List;
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

    }
}
