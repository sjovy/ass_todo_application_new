package se.lexicon.dao;

import se.lexicon.model.*;

import java.util.*;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{
    private List<TodoItemTask> todoItemsTaskList = new ArrayList<>();

    @Override
    public void persist(TodoItemTask it) {
        todoItemsTaskList.add(it);
    }

    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask it : todoItemsTaskList) {
            if (it.getId() == id) {
                return it;
            }
        }
        return null;
    }

    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemsTaskList);
    }

    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean assigned) {
        List<TodoItemTask> outputList = new ArrayList<>();
        for (TodoItemTask it : todoItemsTaskList) {
            if (it.isAssigned() == assigned) {
                outputList.add(it);
            }
        }
        return outputList;
    }

    @Override
    public List<TodoItemTask> findByPersonId(int personId) {
        List<TodoItemTask> outputList = new ArrayList<>();
        for (TodoItemTask it : todoItemsTaskList) {
            if (it.getAssignee().getPersonId() == personId) {
                outputList.add(it);
            }
        }
        return outputList;
    }

    @Override
    public void remove(TodoItemTask it) {
        todoItemsTaskList.remove(it);
    }

}
