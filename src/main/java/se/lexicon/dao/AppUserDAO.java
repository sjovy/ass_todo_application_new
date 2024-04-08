package se.lexicon.dao;

import se.lexicon.model.AppUser;

import java.util.List;

public interface AppUserDAO {
    void persist(AppUser user);
    AppUser findByUsername(String username);
    List<AppUser> findAll();
    void remove(AppUser user);
}