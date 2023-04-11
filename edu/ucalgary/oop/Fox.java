package edu.ucalgary.oop;
/**

 The Fox class is a subclass of the Animal class, representing a porcupine
 animal in the volunteer shelter.
 It defines the feeding schedule and cleaning requirements for the porcupine enclosure.
 */
public class Fox extends Animal {
    /**
     * The times at which animals are fed in hours (military time).
     * For this schedule, feeding times are midnight, 1 AM, and 2 AM.
     */
    private static final int[] FEEDINGTIME = {0, 1, 2};

    /**
     * The amount of time in minutes required to prepare food for the animals.
     * For this schedule, no preparation time is needed.
     */
    private static final int PREPTIME = 5;

    /**
     * The duration in minutes that each feeding session lasts.
     * For this schedule, each feeding session lasts for 5 minutes.
     */
    private static final int FEEDDURATION = 5;

    /**
     * The amount of time in minutes required to clean the animal enclosures.
     * For this schedule, each enclosure requires 5 minutes of cleaning time.
     */
    private static final int CLEANINGTIME = 5;

    /**
     * Constructor for creating an instance of the Porcupine class
     *
     * @param animalID       - the ID of the porcupine
     * @param animalNickname - the nickname of the porcupine
     * @param animalSpecies  - the species of the porcupine
     */
    public Fox(int animalID, String animalNickname, String animalSpecies) {
        super(animalID, animalNickname, animalSpecies);
    }

    // Getter methods for feeding time, preparation time, feeding duration, and cleaning time
    public int[] getFeedWindow() {
        return FEEDINGTIME;
    }

    public int getPrepTime() {
        return PREPTIME;
    }

    public int getFeedTime() {
        return FEEDDURATION;
    }

    public int getCleanTime() {
        return CLEANINGTIME;
    }
}

