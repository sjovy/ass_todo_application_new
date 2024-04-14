package se.lexicon.dao;

import se.lexicon.model.*;

import java.util.List;

public interface TodoItemTaskDAO {
    void persist(TodoItemTask todoItemTask);
    TodoItemTask findById(int id);
    List <TodoItemTask> findAll();
    List <TodoItemTask> findByAssignedStatus(boolean assigned);
    List <TodoItemTask> findByPersonId(int personId);
    void remove(TodoItemTask todoItemTask);
}
