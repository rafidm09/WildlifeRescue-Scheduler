package edu.ucalgary.oop;

public class Treatment {
    
        private int animalID;
        private Task task;
        private int startHour;
    
        public Treatment(int animalID, Task task, int startHour) throws IllegalArgumentException {
            setAnimalID(animalID);
            setTask(task);
            setStartHour(startHour);
        }
    
        public int getAnimalID() {
            return animalID;
        }
    
        public Task getTask() {
            return task;
        }
    
        public int getStartHour() {
            return startHour;
        }
    
        public void setAnimalID(int animalID) throws IllegalArgumentException {
            if (animalID < 0) {
                throw new IllegalArgumentException("Invalid animalID");
            }
            this.animalID = animalID;
        }
    
        public void setTask(Task task) throws IllegalArgumentException {
            if (task == null) {
                throw new IllegalArgumentException("Invalid task");
            }
            this.task = task;
        }
    
        public void setStartHour(int startHour) throws IllegalArgumentException {
            if (startHour < 0) {
                throw new IllegalArgumentException("Invalid startHour");
            }
            this.startHour = startHour;
        }
    }
    
    

