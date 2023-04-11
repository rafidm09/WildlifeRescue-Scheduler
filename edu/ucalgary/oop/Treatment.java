package edu.ucalgary.oop;

public class Treatment {
    
        private int animalID;
        private int taskID;
        private int startHour;
    
        public Treatment(int animalID, int taskID, int startHour) throws IllegalArgumentException {
            this.animalID = animalID;
            this.taskID = taskID;
            this.startHour = startHour;
        }
    
        public int getAnimalID() {
            return animalID;
        }
    
        public int getTask() {
            return taskID;
        }
    
        public int getStartHour() {
            return startHour;
        }
    

    }
    
    

