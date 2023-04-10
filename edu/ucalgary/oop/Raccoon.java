package edu.ucalgary.oop;

public class Raccoon extends Animal {
    private static final int[] FEEDINGTIME = {0, 1, 2};
    private static final int PREPTIME = 0;
    private static final int FEEDDURATION = 5;
    private static final int CLEANINGTIME = 5;

    // Constructor for creating an instance of the Raccoon class
    // @param animalNickname - the nickname of the raccoon
    public Raccoon(int animalID, String animalNickname, String animalSpecies) {
        super(animalID, animalNickname, animalSpecies);
    }

    // Getter methods for feeding window, preparation time, feeding time, and cleaning time
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

