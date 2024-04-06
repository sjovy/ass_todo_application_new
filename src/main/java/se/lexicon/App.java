package se.lexicon;

import static se.lexicon.AppRole.ROLE_APP_USER;

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
        System.out.println(u1.equals(p1));


    }
}
