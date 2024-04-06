package se.lexicon;

import java.time.LocalDate;

public class TodoItem {
    // Fields:
    private final int id;
    private static int nextID = 100;
    private String title;
    private String taskDescription;
    private final Person creator;
    private LocalDate deadline;
    private boolean done;

    // Constructor:
    public TodoItem(String title, String taskDescription, Person creator, String deadline){
        this.id = ++nextID;
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
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public boolean isDone() {
        return done;
    }

    // Other:
    public boolean isOverdue(){
        LocalDate today = LocalDate.now();
        return today.isAfter(deadline) && !done;
    }

    // Output info:
    public void getSummary(){
        System.out.println("ID: " + getId() +
                ", Title: " + getTitle() + ", Description: " + getTaskDescription() +
                ", Creator: " + creator.getFirstName() + " " + creator.getLastName() +
                ", Deadline: " + getDeadline() + ", DunnIt: " + isDone() + ", Overdue: " + isOverdue());
    }
}