package se.lexicon.model;

import java.util.Objects;

public class AppUser {

    // Fields:
    private String user;
    private String password;
    private AppRole role;

    // Constructor:
    public AppUser(String user, String password, AppRole role){
        setUser(user);
        setPassword(password);
        setRole(role);
    }

    // Setters:
    public void setUser(String user) {
        if (user == null || user.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.user = user;
    }

    public void setPassword(String password) {
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.password = password;
    }

    public void setRole(AppRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.role = role;
    }

    // Getters:

    // Other:

    @Override
    public int hashCode() {
        return Objects.hash(user, role);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return Objects.equals(user, appUser.user) && role == appUser.role;
    }

    // Output:
    @Override
    public String toString() {
        return "AppUser: { User=" + user + ", Role=" + role + " }";
    }
}


