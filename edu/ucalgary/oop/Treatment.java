package edu.ucalgary.oop;
/**
 The Treatment class represents a medical treatment to be given to an animal at a specified start hour.
 */
public class Treatment {

    private int animalID;    // ID of the animal receiving the treatment
    private int taskID;      // ID of the task being performed for the treatment
    private int startHour;   // Starting hour (in military time) of the treatment

    /**
     * Constructs a new Treatment object with the given parameters.
     *
     * @param animalID ID of the animal receiving the treatment
     * @param taskID ID of the task being performed for the treatment
     * @param startHour Starting hour (in military time) of the treatment
     *
     * @throws IllegalArgumentException if any of the input parameters are invalid.
     */
    public Treatment(int animalID, int taskID, int startHour) throws IllegalArgumentException {
        this.animalID = animalID;
        this.taskID = taskID;
        this.startHour = startHour;
    }

    /**
     * Returns the ID of the animal receiving the treatment.
     *
     * @return the ID of the animal receiving the treatment.
     */
    public int getAnimalID() {
        return animalID;
    }

    /**
     * Returns the ID of the task being performed for the treatment.
     *
     * @return the ID of the task being performed for the treatment.
     */
    public int getTask() {
        return taskID;
    }

    /**
     * Returns the starting hour (in military time) of the treatment.
     *
     * @return the starting hour (in military time) of the treatment.
     */
    public int getStartHour() {
        return startHour;
    }
}
