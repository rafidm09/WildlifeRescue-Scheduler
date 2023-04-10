package edu.ucalgary.oop;

public class Animal {
    private int animalID;
    private String animalNickname;
    private String animalSpecies;

    public Animal (int animalID, String animalNickname, String animalSpecies) {
        if (animalID < 0 || animalNickname == null || animalNickname.isEmpty() || animalSpecies == null || animalSpecies.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters for Animals constructor");
        }
        this.animalID = animalID;
        this.animalNickname = animalNickname;
        this.animalSpecies = animalSpecies;
    }

    public int getAnimalID() {
        return animalID;
    }
    public String getAnimalNickname() {
        return animalNickname;
    }

    public String getAnimalSpecies() {
        return animalSpecies;
    }
}
