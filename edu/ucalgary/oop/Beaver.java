package edu.ucalgary.oop;

/**

 The Beaver class is a subclass of the Animal class, representing a porcupine
 animal in the volunteer shelter.
 It defines the feeding schedule and cleaning requirements for the porcupine enclosure.
 */
public class Beaver extends Animal {
    /**
     * The times at which animals are fed in hours.
     */
    private static final int[] FEEDINGTIME = {8, 9, 10};

    /**
     * The amount of time in minutes required to prepare food for the animals.
     */
    private static final int PREPTIME = 0;

    /**
     * The duration in minutes that each feeding session lasts.
     */
    private static final int FEEDDURATION = 5;

    /**
     * The amount of time in minutes required to clean the animal enclosures.
     */
    private static final int CLEANINGTIME = 5;

    /**
     * Constructor for creating an instance of the Porcupine class
     *
     * @param animalID       - the ID of the porcupine
     * @param animalNickname - the nickname of the porcupine
     * @param animalSpecies  - the species of the porcupine
     */
    public Beaver(int animalID, String animalNickname, String animalSpecies) {
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
