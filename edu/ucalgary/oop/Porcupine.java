package edu.ucalgary.oop;

public class Porcupine {

    private static final int[] FEED_WINDOW = {19, 20, 21};
    private static final int PREP_TIME = 0;
    private static final int FEED_TIME = 5;
    private static final int CLEAN_TIME = 10;

    // Constructor for creating an instance of the Porcupine class
    // @param animalNickname - the nickname of the porcupine
    public Porcupine(int animalID, String animalNickname, String animalSpecies) {
        super(animalID, animalNickname, animalSpecies);
    }

    // Getter methods for feeding window, preparation time, feeding time, and cleaning time
    public int[] getFeedWindow() {
        return FEED_WINDOW;
    }

    public int getPrepTime() {
        return PREP_TIME;
    }

    public int getFeedTime() {
        return FEED_TIME;
    }

    public int getCleanTime() {
        return CLEAN_TIME;
    }
}
