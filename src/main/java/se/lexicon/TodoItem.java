package se.lexicon;

import se.lexicon.sequencers.TodoItemIDSequencer;

import java.time.LocalDate;
import java.util.Objects;

public class TodoItem {
    // Fields:
    private final int id;
    private String title;
    private String taskDescription;
    private final Person creator;
    private LocalDate deadline;
    private boolean done;

    // Constructor:
    public TodoItem(String title, String taskDescription, Person creator, String deadline){
        this.id = TodoItemIDSequencer.nextId();
        setTitle(title);
        setTaskDescription(taskDescription);
        this.creator = creator;
        setDeadline(deadline);
        this.done = false;
    }

    // Setters:
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.title = title;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public void setDeadline(String deadline) {
        if (deadline == null || deadline.trim().isEmpty()) {
            throw new IllegalArgumentException("Input cannot be null or empty.");
        }
        this.deadline = LocalDate.parse(deadline);
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    // Getters:

    // Other:
    public boolean isOverdue(){
        LocalDate today = LocalDate.now();
        return today.isAfter(deadline) && !done;
    }

    // equals() & hashCode() all fields except Person objects
    @Override
    public int hashCode() {
        return Objects.hash(id, title, taskDescription, deadline, done);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return id == todoItem.id && done == todoItem.done && title.equals(todoItem.title) &&
                taskDescription.equals(todoItem.taskDescription) && deadline.equals(todoItem.deadline);
    }

    // Output info:
    @Override
    public String toString() {
        return "TodoItem: { ID=" + id +
                ", Title=" + title + ", Description=" + taskDescription +
                ", Deadline=" + deadline + ", Done=" + done + ", Overdue=" + isOverdue() + " }";
    }

}
