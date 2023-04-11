package edu.ucalgary.oop;
/**
 The Task class represents a task required to be done for animal(s).
 */
public class Task {
    private int taskID;
    private String description;
    private int duration;
    private int maxWindow;

    /**
     * Constructs a Task object with the specified task ID, description, duration, and maximum window.
     *
     * @param taskID the ID of the task
     * @param description the description of the task
     * @param duration the duration of the task in minutes
     * @param maxWindow the maximum window of time in which the task can be performed in minutes
     * @throws IllegalArgumentException if the taskID, duration, or maxWindow is negative or if the description is null or empty
     */
    public Task(int taskID, String description, int duration, int maxWindow) throws IllegalArgumentException {
        setTaskID(taskID);
        setDescription(description);
        setDuration(duration);
        setMaxWindow(maxWindow);
    }

    /**
     * Returns the ID of the task.
     *
     * @return the ID of the task
     */
    public int getTaskID() {
        return taskID;
    }

    /**
     * Returns the description of the task.
     *
     * @return the description of the task
     */
    public String getDescription() {
        return description;
    }

    /**
     * Returns the duration of the task in minutes.
     *
     * @return the duration of the task in minutes
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Returns the maximum window of time in which the task can be performed in minutes.
     *
     * @return the maximum window of time in which the task can be performed in minutes
     */
    public int getMaxWindow() {
        return maxWindow;
    }

    /**
     * Sets the ID of the task.
     *
     * @param taskID the ID of the task
     * @throws IllegalArgumentException if the taskID is negative
     */
    public void setTaskID(int taskID) throws IllegalArgumentException {
        if (taskID < 0) {
            throw new IllegalArgumentException("Invalid taskID");
        }
        this.taskID = taskID;
    }

    /**
     * Sets the description of the task.
     *
     * @param description the description of the task
     * @throws IllegalArgumentException if the description is null or empty
     */
    public void setDescription(String description) throws IllegalArgumentException {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.description = description;
    }

    /**
     * Sets the duration of the task in minutes.
     *
     * @param duration the duration of the task in minutes
     * @throws IllegalArgumentException if the duration is negative
     */
    public void setDuration(int duration) throws IllegalArgumentException {
        if (duration < 0) {
            throw new IllegalArgumentException("Invalid duration");
        }
        this.duration = duration;
    }

/**
 * Sets the maximum window of time in which the task can be performed in minutes.
 *
 * @param maxWindow the number of hours it can take from start time
 * * @throws IllegalArgumentException if the duration is negative
 */

    public void setMaxWindow(int maxWindow) throws IllegalArgumentException {
        if (maxWindow < 0) {
            throw new IllegalArgumentException("Invalid maxWindow");
        }
        this.maxWindow = maxWindow;
    }
}
