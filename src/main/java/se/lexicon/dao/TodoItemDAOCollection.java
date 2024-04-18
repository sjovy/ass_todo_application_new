package se.lexicon.dao;

import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TodoItemDAOCollection implements TodoItemDAO {

    private List<TodoItem> todoItemsList = new ArrayList<>();

    @Override
    public void persist(TodoItem tdi) {
        todoItemsList.add(tdi);
    }

    @Override
    public List<TodoItem> findAll() {
        return Collections.unmodifiableList(todoItemsList);
    }

    @Override
    public void remove(TodoItem todoItem) {
        todoItemsList.removeIf(p -> p.equals(todoItem));
    }

    @Override
    public TodoItem findById(int id) {
        return todoItemsList.stream()
                .filter(tdi -> tdi.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TodoItem> findMany(Predicate<TodoItem> condition) {
        return todoItemsList.stream()
                            .filter(condition)
                            .collect(Collectors.toList());
    }

    @Override
    public List<TodoItem> findByPersonId(int personId) {
        return findMany(tdi -> tdi.getCreator().getPersonId() == personId);
    }

    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate deadline) {
        return findMany(tdi -> tdi.getDeadline().isBefore(deadline));
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate deadline) {
        return findMany(tdi -> tdi.getDeadline().isAfter(deadline));
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(boolean done) {
        return findMany(tdi -> tdi.isDone() == done);
    }

    @Override
    public List<TodoItem> findByTitleContains(String title) {
        return findMany(tdi -> tdi.getTitle().contains(title));
    }


}
