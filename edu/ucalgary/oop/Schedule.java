package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

class Schedule {
    // Contains the timetable
    HashMap<String, Treatment> scheduleMap = new HashMap<>();

    // MaxWindow -> TaskID
    HashMap<Integer, ArrayList<Integer>> taskPriorityMap = new HashMap<>();

    HashMap<Integer, Animal> animalMap = new HashMap<>();
    HashMap<Integer, Task> taskMap = new HashMap<>();
    HashMap<Integer, Treatment> treatmentMap = new HashMap<>();


    private ArrayList<Coyote> coyotes;
    private ArrayList<Beaver> beavers;
    private ArrayList<Fox> foxes;
    private ArrayList<Raccoon> raccoons;
    private ArrayList<Porcupine> porcupines;
    private ArrayList<Task> tasks;
    private ArrayList<Treatment> treatments;

    public Schedule() {
        Database db = new Database();
        db.createConnection();

        db.selectAnimals();
        this.coyotes = db.getCoyotes();
        this.beavers = db.getBeavers();
        this.foxes = db.getFoxes();
        this.raccoons = db.getRaccoons();
        this.porcupines = db.getPorcupines();

        this.tasks = db.selectTasks();
        this.treatments = db.selectTreatments();
    }

    public void initializeData() {
        // initialize all timetable values to null
        for (int i = 0; i < 24; i++) {
            this.scheduleMap.put(String.valueOf(i), null);
        }

        for (int i = 1; i < 6; i++) {
            this.taskPriorityMap.put(i, new ArrayList<>());
        }

        // initialize priority map -> maxwindow -> task
        for (int i = 0; i < this.tasks.size(); i++) {
            int maxWindow = this.tasks.get(i).getMaxWindow();
            int taskID = this.tasks.get(i).getTaskID();

            ArrayList<Integer> temp = this.taskPriorityMap.get(maxWindow);

            temp.add(taskID);

            this.taskPriorityMap.put(maxWindow, temp);
        }

        // initalize AnimalMap
        for (int i = 0; i < this.coyotes.size(); i++) {
            this.animalMap.put(this.coyotes.get(i).getAnimalID(), this.coyotes.get(i));
        }
        for (int i = 0; i < this.beavers.size(); i++) {
            this.animalMap.put(this.beavers.get(i).getAnimalID(), this.beavers.get(i));
        }
        for (int i = 0; i < this.foxes.size(); i++) {
            this.animalMap.put(this.foxes.get(i).getAnimalID(), this.foxes.get(i));
        }
        for (int i = 0; i < this.raccoons.size(); i++) {
            this.animalMap.put(this.raccoons.get(i).getAnimalID(), this.raccoons.get(i));
        }
        for (int i = 0; i < this.porcupines.size(); i++) {
            this.animalMap.put(this.porcupines.get(i).getAnimalID(), this.porcupines.get(i));
        }

        // initialize TaskMap
        for (int i = 0; i < this.tasks.size(); i++) {
            this.taskMap.put(this.tasks.get(i).getTaskID(), this.tasks.get(i));
        }

        // initialize TreatmentMap
        for (int i = 0; i < this.treatments.size(); i++) {
            this.treatmentMap.put(this.treatments.get(i).getAnimalID(), this.treatments.get(i));
        }
    }

    public void makeSchedule() {
        // schedule priority one
        int priorityFlag = 1;

        ArrayList<Integer> tasks = this.taskPriorityMap.get(priorityFlag);

        Set<Integer> treatmentKeys = this.treatmentMap.keySet();
        for (Integer i: treatmentKeys) {
            Treatment treatment = this.treatmentMap.get(i);
			
            System.out.println(treatment.getTask());
			Integer startHour = treatment.getStartHour();
			
			this.scheduleMap.put(String.valueOf(startHour), treatment);
			System.out.println(String.valueOf(startHour) + " -> " + this.scheduleMap.get(String.valueOf(startHour)).getTask());
        }
		
    }

    public HashMap<String, Treatment> getSchedule() {
        return this.scheduleMap;
    }
}