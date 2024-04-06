package se.lexicon;

public class App {

    public static void main(String[] args) {
        Person p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        p1.getSummary();
        Person p2 = new Person("Lasse", "Ohlsson", "lo@home.se");
        p2.getSummary();
        Person p3 = new Person("Olle", "Björk", "ob@yahoo.com");
        p3.getSummary();
        TodoItem i1 = new TodoItem("Städa", "som fan", p1, "2024-04-10");
        i1.getSummary();
        i1.setDone(true);
        i1.getSummary();


        TodoItemTask t1 = new TodoItemTask(p2, i1);
        t1.getSummary();
        TodoItemTask t2 = new TodoItemTask(p3, i1);
        t2.getSummary();
        TodoItemTask t3 = new TodoItemTask(i1);
        t3.getSummary();


    }
}
