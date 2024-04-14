package se.lexicon.dao;

import se.lexicon.model.*;

import java.time.*;
import java.util.List;

public interface TodoItemDAO {

    void persist(TodoItem todoItem);
    TodoItem findById(int id);
    List<TodoItem> findAll();
    List <TodoItem> findAllByDoneStatus(boolean done);
    List <TodoItem> findByTitleContains(String title);
    List <TodoItem> findByPersonId(int personId);
    List <TodoItem> findByDeadlineBefore(LocalDate deadline);
    List <TodoItem> findByDeadlineAfter(LocalDate deadline);
    void remove(TodoItem todoItem);

}
