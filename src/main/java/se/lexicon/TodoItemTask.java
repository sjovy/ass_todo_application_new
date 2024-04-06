package se.lexicon;

import java.util.Objects;

public class TodoItemTask {

    // Fields:
    private final int id;
    private static int nextID = 0;
    private Person assignee;
    private boolean assigned;
    private TodoItem todoItem;

    // Constructor:
    public TodoItemTask(Person assignee, TodoItem todoItem){
        this.id = ++nextID;
        this.assigned = false;
        setAssignee(assignee);
        setTodoItem(todoItem);
    }

    // Setters:
    public void setAssignee(Person assignee) {
        if (assignee == null) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.assignee = assignee;
        setAssigned(true);
    }

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    public void setTodoItem(TodoItem todoItem) {
        if (todoItem == null) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.todoItem = todoItem;
    }

    // Getters:
    public int getId() {
        return id;
    }

    public boolean isAssigned() {
        return assigned;
    }

    // Other:
    @Override
    public int hashCode() {
        return Objects.hash(id, assigned, todoItem);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItemTask)) return false;
        TodoItemTask that = (TodoItemTask) o;
        return id == that.id;
    }

    // Output:
    @Override
    public String toString() {
        return "TodoItemTask: { ID=" + id + ", Item=" + todoItem + ", Assigned=" + assigned + " }";
    }
}
