package se.lexicon.dao;

import se.lexicon.model.*;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;

public class TodoItemDAOCollection implements TodoItemDAO {

    private List<TodoItem> todoItemsList = new ArrayList<>();

    @Override
    public void persist(TodoItem tdi) {
        todoItemsList.add(tdi);
    }

    @Override
    public TodoItem findById(int id) {
        for (TodoItem tdi : todoItemsList) {
            if (tdi.getId() == id) {
                return tdi;
            }
        }
        return null;
    }

    @Override
    public List<TodoItem> findAll() {
        return new ArrayList<>(todoItemsList);
    }

    @Override
    public List<TodoItem> findAllByDoneStatus(boolean done) {

        // Set up a list to hold the todoItems based on the done status
        List<TodoItem> outputList = new ArrayList<>();

        for (TodoItem tdi : todoItemsList) {
            if (tdi.isDone() == done) {
                outputList.add(tdi);
            }
        }
        return outputList;
    }

    @Override
    public List<TodoItem> findByTitleContains(String title) {

        // Set up a list to hold the todoItems based on the title
        List<TodoItem> outputList = new ArrayList<>();

        for (TodoItem tdi : todoItemsList) {
            String todoItemTitle = tdi.getTitle();
            if (todoItemTitle.contains(title)) {
                outputList.add(tdi);
            }
        }
        return outputList;
    }


    /*@Override
    public List<TodoItem> find(Predicate<TodoItem> filter) {

        // Set up a list to hold the todoItems based on the title
        List<TodoItem> outputList = new ArrayList<>();

        for (TodoItem tdi : todoItemsList) {
            if (filter.test(tdi)) {
                outputList.add(tdi);
            }
        }
        return outputList;
        // return todoItemsList.stream().filter(tdi -> tdi.getTitle().contains(title)).toList();
    }*/

    @Override
    public List<TodoItem> findByPersonId(int personId) {

        // Set up a list to hold the todoItems based on the creator's ID
        List<TodoItem> outputList = new ArrayList<>();

        for (TodoItem tdi : todoItemsList) {
            Person todoItemCreator = tdi.getCreator();
            if (todoItemCreator.getPersonId() == personId) {
                outputList.add(tdi);
            }
        }
        return outputList;
    }

    @Override
    public List<TodoItem> findByDeadlineBefore(LocalDate deadline) {

        // Set up a list to hold the todoItems based on the deadline
        List<TodoItem> outputList = new ArrayList<>();

        for (TodoItem tdi : todoItemsList) {
            LocalDate todoItemDeadline = tdi.getDeadline();
            if (todoItemDeadline.isBefore(deadline)) {
                outputList.add(tdi);
            }
        }
        return outputList;
    }

    @Override
    public List<TodoItem> findByDeadlineAfter(LocalDate deadline) {

        // Set up a list to hold the todoItems based on the deadline
        List<TodoItem> outputList = new ArrayList<>();

        for (TodoItem tdi : todoItemsList) {
            LocalDate todoItemDeadline = tdi.getDeadline();
            if (todoItemDeadline.isAfter(deadline)) {
                outputList.add(tdi);
            }
        }
        return outputList;
    }

    @Override
    public void remove(TodoItem todoItem) {
        todoItemsList.remove(todoItem);
    }
}
