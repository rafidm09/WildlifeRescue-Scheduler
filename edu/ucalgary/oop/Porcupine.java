package edu.ucalgary.oop;

public class Porcupine extends Animal {

    private static final int[] FEEDINGTIME = {19, 20, 21};
    private static final int PREPTIME = 0;
    private static final int FEEDDURATION = 5;
    private static final int CLEANINGTIME = 10;

    // Constructor for creating an instance of the Porcupine class
    // @param animalNickname - the nickname of the porcupine
    public Porcupine(int animalID, String animalNickname, String animalSpecies) {
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
