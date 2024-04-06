package se.lexicon;

public class Person {

    // Fields:
    private final int id;
    private static int nextID = 10000;
    private String firstName;
    private String lastName;
    private String email;

    // Constructor:
    public Person(String firstName, String lastName, String email) {
        this.id = ++nextID;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    // Setters:
    private void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    private void setEmail(String email) {
        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.email = email;
    }

    // Getters:
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }
    
    // Output info:
    public void getSummary(){
        System.out.println("ID: " + getId() +
                ", Name: " + getFirstName() + " " + getLastName() +
                ", email: " + getEmail());
    }
}
