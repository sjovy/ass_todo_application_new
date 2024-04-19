package se.lexicon.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import se.lexicon.sequencers.PersonIDSequencer;

import java.util.Objects;

public class Person {

    // Fields:
    @JsonProperty("personId")
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private AppUser credentials;

    // Default constructor
    public Person() {
        this.id = PersonIDSequencer.nextId();
    }

    // Existing constructor:
    public Person(String firstName, String lastName, String email) {
        //this.id = PersonIDSequencer.nextId();
        this();
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    // Setters:
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.email = email;
    }

    public void setCredentials(AppUser credentials) {
        this.credentials = credentials;
    }

    // Getters:
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public AppUser getCredentials() {
        return credentials;
    }

    public int getPersonId() {
        return id;
    }

     public String getEmail() {
        return email;
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
    StringBuilder sb = new StringBuilder();
    sb.append("Person: { ID=").append(id);
    sb.append(", Name=").append(firstName).append(" ").append(lastName);
    sb.append(", email=").append(email).append(" }");
    return sb.toString();
    }
}
