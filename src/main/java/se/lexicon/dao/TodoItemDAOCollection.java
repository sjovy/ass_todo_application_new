package se.lexicon.dao;

import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.*;

public class TodoItemDAOCollection implements TodoItemDAO{

    private List<TodoItem> todoItemsList = new ArrayList<>();

    // persist: add new TodoItem.class object to collection
    @Override
    public void persist(TodoItem todoItem) {
        todoItemsList.add(todoItem);
    }

    // findById: find TodoItem.class object by id
    @Override
    public TodoItem findById(int id) {
        for (TodoItem todoItem : todoItemsList) {
            if (todoItem.getId() == id) {
                return todoItem;
            }
        }
        return null;
    }

    // findAll: return all TodoItem.class objects
    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(todoItemsList);
    }

    // findAllByDoneStatus: return all TodoItem.class objects by done status
    @Override
    public List<TodoItem> findAllByDoneStatus(boolean done) {
        List<TodoItem> doneList = new ArrayList<>();
        for (TodoItem todoItem : todoItemsList) {
            if (todoItem.isDone() == done) {
                doneList.add(todoItem);
            }
        }
        return doneList;
    }

    // findByTitleContains: return all TodoItem.class objects by title
    @Override
    public List<TodoItem> findByTitleContains(String title) {
        List<TodoItem> titleList = new ArrayList<>();
        for (TodoItem todoItem : todoItemsList) {
            // ---
            if (todoItem.getTitle().contains(title)) {
                titleList.add(todoItem);
            }
        }
        return titleList;
    }

    // findByPersonId: return all TodoItem.class objects by person id
    @Override
    public List<TodoItem> findByPersonId(int personId) {
        List<TodoItem> personsList = new ArrayList<>();
        for (TodoItem todoItem : todoItemsList) {
            // ---
            if (todoItem.getCreator().getPersonId() == personId) {
                personsList.add(todoItem);
            }
        }
        return personsList;
    }

    // findByDeadlineBefore: return all TodoItem.class objects by deadline before
    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate deadline) {
        List<TodoItem> deadlineList = new ArrayList<>();
        for (TodoItem todoItem : todoItemsList) {
            // ---
            if (todoItem.getDeadline().isBefore(deadline)) {
                deadlineList.add(todoItem);
            }
        }
        return deadlineList;
    }

    // findByDeadlineAfter: return all TodoItem.class objects by deadline after
    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate deadline) {
        List<TodoItem> deadlineList = new ArrayList<>();
        for (TodoItem todoItem : todoItemsList) {
            // ---
            if (todoItem.getDeadline().isAfter(deadline)) {
                deadlineList.add(todoItem);
            }
        }
        return deadlineList;
    }

    // remove: remove TodoItem.class object from collection
    @Override
    public void remove(TodoItem todoItem) {
        todoItemsList.remove(todoItem);
    }
}
