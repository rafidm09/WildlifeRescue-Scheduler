package edu.ucalgary.oop;

public class Task {
    private int taskID;
    private String description;
    private int duration;
    private int maxWindow;

    public Task(int taskID, String description, int duration, int maxWindow) {
        setTaskID(taskID);
        setDescription(description);
        setDuration(duration);
        setMaxWindow(maxWindow);
    }

    public int getTaskID() {
        return taskID;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public int getMaxWindow() {
        return maxWindow;
    }

    public void setTaskID(int taskID) throws IllegalArgumentException {
        if (taskID < 0) {
            throw new IllegalArgumentException("Invalid taskID");
        }
        this.taskID = taskID;
    }

    public void setDescription(String description) throws IllegalArgumentException {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    public void setDuration(int duration) throws IllegalArgumentException {
        if (duration < 0) {
            throw new IllegalArgumentException("Invalid duration");
        }
        this.duration = duration;
    }

    public void setMaxWindow(int maxWindow) throws IllegalArgumentException {
        if (maxWindow < 0) {
            throw new IllegalArgumentException("Invalid maxWindow");
        }
        this.maxWindow = maxWindow;
    }
}
