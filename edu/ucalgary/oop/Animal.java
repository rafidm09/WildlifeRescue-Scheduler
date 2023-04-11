package edu.ucalgary.oop;

/**

 The Animal class represents an animal in the shelter.

 Each animal has an ID, a nickname, and a species.
 */
public class Animal {
    private int animalID;
    private String animalNickname;
    private String animalSpecies;



    /**
     * Constructs a new Animal with the given ID, nickname, and species.
     *
     * @param animalID the ID of the animal being created. Must be greater than or equal to 0.
     * @param animalNickname the nickname or name of the animal being created. Must not be null or empty.
     * @param animalSpecies the species of the animal being created. Must not be null or empty.
     *
     * @throws IllegalArgumentException if any of the input parameters are invalid.
     */
    public Animal (int animalID, String animalNickname, String animalSpecies) {
        if (animalID < 0 || animalNickname == null || animalNickname.isEmpty() || animalSpecies == null || animalSpecies.isEmpty()) {
            throw new IllegalArgumentException("Invalid input parameters for Animals constructor");
        }
        this.animalID = animalID;
        this.animalNickname = animalNickname;
        this.animalSpecies = animalSpecies;
    }

    /**
     * Returns the ID of this animal.
     *
     * @return the ID of this animal
     */
    public int getAnimalID() {
        return animalID;
    }

    /**
     * Returns the nickname of this animal.
     *
     * @return the nickname of this animal
     */
    public String getAnimalNickname() {
        return animalNickname;
    }



    /**
     * Returns the species of this animal.
     *
     * @return the species of this animal
     */
    public String getAnimalSpecies() {
        return animalSpecies;
    }
}
