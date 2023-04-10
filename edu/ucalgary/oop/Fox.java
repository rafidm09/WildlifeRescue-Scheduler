package edu.ucalgary.oop;

public class Fox extends Animal {
    private static final int[] FEEDINGTIME = {0, 1, 2};
    private static final int PREPTIME = 5;
    private static final int FEEDDURATION = 5;
    private static final int CLEANINGTIME = 5;

    // Constructor for creating an instance of the fox class
    // @param animalNickname - the nickname of the fox
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

