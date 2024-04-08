package se.lexicon;

import se.lexicon.dao.AppUserDAO;
import se.lexicon.dao.AppUserDAOCollection;
import se.lexicon.model.AppUser;
import se.lexicon.model.Person;
import se.lexicon.model.TodoItem;
import se.lexicon.model.TodoItemTask;

import java.util.List;

import static se.lexicon.model.AppRole.ROLE_APP_ADMIN;
import static se.lexicon.model.AppRole.ROLE_APP_USER;

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

        AppUserDAO appUserDAO = new AppUserDAOCollection();

        appUserDAO.persist(u1);
        AppUser foundUser = appUserDAO.findByUsername("Thomas");
        System.out.println(foundUser);

        appUserDAO.persist(u2);
        List<AppUser> allUsers = appUserDAO.findAll();
        for (AppUser user : allUsers) {
            System.out.println(user);
}
        // appUserDAO.remove(u1);


    }
}
