package edu.ucalgary.oop;


/**
 The Porcupine class is a subclass of the Animal class, representing a porcupine
 animal in the volunteer shelter.
 It defines the feeding schedule and cleaning requirements for the porcupine enclosure.
 */

public class Porcupine extends Animal {

    /**
     * The times at which animals are fed in hours (military time).
     * For this schedule, feeding times are 7 PM, 8 PM, and 9 PM.
     */
    private static final int[] FEEDINGTIME = {19, 20, 21};

    /**
     * The amount of time in minutes required to prepare food for the animals.
     * For this schedule, no preparation time is needed.
     */
    private static final int PREPTIME = 0;

    /**
     * The duration in minutes that each feeding session lasts.
     * For this schedule, each feeding session lasts for 5 minutes.
     */
    private static final int FEEDDURATION = 5;

    /**
     * The amount of time in minutes required to clean the animal enclosures.
     * For this schedule, each enclosure requires 10 minutes of cleaning time.
     */
    private static final int CLEANINGTIME = 10;

    /**
     * Constructor for creating an instance of the Porcupine class
     *
     * @param animalID       - the ID of the porcupine
     * @param animalNickname - the nickname of the porcupine
     * @param animalSpecies  - the species of the porcupine
     */
    public Porcupine(int animalID, String animalNickname, String animalSpecies) {
        super(animalID, animalNickname, animalSpecies);
    }

    /**
     * Returns the feeding times for the porcupine enclosure.
     *
     * @return an array of integers representing the feeding times in military time
     */
    public int[] getFeedWindow() {
        return FEEDINGTIME;
    }

    /**
     * Returns the amount of time in minutes required to prepare food for the porcupines.
     *
     * @return an integer representing the preparation time in minutes
     */
    public int getPrepTime() {
        return PREPTIME;
    }

    /**
     * Returns the duration in minutes that each feeding session lasts for the porcupines.
     *
     * @return an integer representing the feeding duration in minutes
     */
    public int getFeedTime() {
        return FEEDDURATION;
    }

    /**
     * Returns the amount of time in minutes required to clean the porcupine enclosure.
     *
     * @return an integer representing the cleaning time in minutes
     */
    public int getCleanTime() {
        return CLEANINGTIME;
    }
}