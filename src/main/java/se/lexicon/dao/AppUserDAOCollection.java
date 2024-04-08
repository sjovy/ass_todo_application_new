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
        for (AppUser user : appUsers) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
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
