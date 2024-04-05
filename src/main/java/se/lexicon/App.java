package se.lexicon;

public class App {

    public static void main(String[] args) {
        Person p1 = new Person("Thomas", "Sjövy", "ts@gmail.com");
        p1.getSummary();
        Person p2 = new Person("Lasse", "Ohlsson", "lo@home.se");
        p2.getSummary();
        TodoItem i1 = new TodoItem("Städa", "som fan", p1, "2024-04-10");
        i1.getSummary();
        i1.setDone(true);
        i1.getSummary();
    }
}
