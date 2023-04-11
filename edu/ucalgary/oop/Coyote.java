package edu.ucalgary.oop;

/**

 The Coyote class is a subclass of the Animal class, representing a porcupine
 animal in the volunteer shelter.
 It defines the feeding schedule and cleaning requirements for the porcupine enclosure.
 */
public class Coyote extends Animal {
    /**
     * The times at which animals are fed in hours (military time).
     * For this schedule, feeding times are 7 PM, 8 PM, and 9 PM.
     */
    private static final int[] FEEDINGTIME = {19, 20, 21};

    /**
     * The amount of time in minutes required to prepare food for the animals.
     * For this schedule, food preparation takes 10 minutes.
     */
    private static final int PREPTIME = 10;

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
    
    public Coyote(int animalID, String animalNickname, String animalSpecies) {
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
