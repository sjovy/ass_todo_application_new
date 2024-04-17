package se.lexicon.dao;

import se.lexicon.model.AppUser;
import java.util.ArrayList;
import java.util.List;

public class AppUserDAOCollection implements AppUserDAO {
    private List<AppUser> appUsers = new ArrayList<>();

    @Override
    public void persist(AppUser user) {
        appUsers.add(user);
    }

    @Override
    public AppUser findByUsername(String username) {
        // in this case i run everything within the return statement
        // note: findFirst returns an Optional, so we need to use orElse(null) to return null if not found.
        return appUsers.stream()
                       .filter(user -> user.getUsername().equals(username))
                       .findFirst()
                       .orElse(null);
}

    @Override
    public List<AppUser> findAll() {
        return new ArrayList<>(appUsers);
    }

    @Override
    public void remove(AppUser user) {
        appUsers.remove(user);
    }
}
