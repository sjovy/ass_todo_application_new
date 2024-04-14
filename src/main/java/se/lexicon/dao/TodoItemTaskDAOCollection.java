package se.lexicon.dao;

import se.lexicon.model.*;

import java.util.*;

public class TodoItemTaskDAOCollection implements TodoItemTaskDAO{
    private List<TodoItemTask> todoItemsTaskList = new ArrayList<>();

    // persist: add new TodoItemTask.class object to collection
    @Override
    public void persist(TodoItemTask todoItemTask) {
        todoItemsTaskList.add(todoItemTask);
    }

    // findById: find TodoItemTask.class object by id
    @Override
    public TodoItemTask findById(int id) {
        for (TodoItemTask todoItemTask : todoItemsTaskList) {
            if (todoItemTask.getId() == id) {
                return todoItemTask;
            }
        }
        return null;
    }

    // findAll: return all TodoItemTask.class objects
    @Override
    public List<TodoItemTask> findAll() {
        return new ArrayList<>(todoItemsTaskList);
    }

    // findByAssignedStatus: return all TodoItemTask.class objects by assigned status
    @Override
    public List<TodoItemTask> findByAssignedStatus(boolean assigned) {
        List<TodoItemTask> assignedList = new ArrayList<>();
        for (TodoItemTask todoItemTask : todoItemsTaskList) {
            if (todoItemTask.isAssigned() == assigned) {
                assignedList.add(todoItemTask);
            }
        }
        return assignedList;
    }

    // findByPersonId: return all TodoItemTask.class objects by person id
    @Override
    public List<TodoItemTask> findByPersonId(int personId) {
        List<TodoItemTask> personsList = new ArrayList<>();
        for (TodoItemTask todoItemTask : todoItemsTaskList) {
            if (todoItemTask.getAssignee().getPersonId() == personId) {
                personsList.add(todoItemTask);
            }
        }
        return personsList;
    }

    // remove: remove TodoItemTask.class object from collection
    @Override
    public void remove(TodoItemTask todoItemTask) {
        todoItemsTaskList.remove(todoItemTask);
    }

}
