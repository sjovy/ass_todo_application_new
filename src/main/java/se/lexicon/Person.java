package se.lexicon;

import se.lexicon.sequencers.PersonIDSequencer;

import java.util.Objects;

public class Person {

    // Fields:
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    // Constructor:
    public Person(String firstName, String lastName, String email) {
        this.id = PersonIDSequencer.nextId();
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

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    // Getters:

    public AppUser getCredentials() {
        return credentials;
    }

    // Other:
    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(firstName, person.firstName) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(email, person.email);
    }

    // Output:
    @Override
    public String toString() {
        return "Person: { ID=" + id + ", Name=" + firstName + " " + lastName + ", email=" + email + " }";
    }
}
