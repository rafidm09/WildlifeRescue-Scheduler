package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.io.*;
import java.time.LocalDate;

class Schedule {
	private LocalDate date;
    private Database db;
    // Contains the timetable
    HashMap<String, Treatment> scheduleMap = new HashMap<>();

    // MaxWindow -> TaskID
    HashMap<Integer, ArrayList<Integer>> taskPriorityMap = new HashMap<>();

    HashMap<Integer, Animal> animalMap = new HashMap<>();
    HashMap<Integer, Task> taskMap = new HashMap<>();
    HashMap<Integer, Treatment> treatmentMap = new HashMap<>();
    HashMap<Integer, Boolean> treatmentTrack = new HashMap<>();


    private ArrayList<Coyote> coyotes;
    private ArrayList<Beaver> beavers;
    private ArrayList<Fox> foxes;
    private ArrayList<Raccoon> raccoons;
    private ArrayList<Porcupine> porcupines;
    private ArrayList<Task> tasks;
    private ArrayList<Treatment> treatments;

    public Schedule(LocalDate date) {
		this.date = date;
        this.db = new Database();
        this.db.createConnection();

        this.db.selectAnimals();
        this.coyotes = this.db.getCoyotes();
        this.beavers = this.db.getBeavers();
        this.foxes = this.db.getFoxes();
        this.raccoons = this.db.getRaccoons();
        this.porcupines = this.db.getPorcupines();

        this.tasks = this.db.selectTasks();
        this.treatments = this.db.selectTreatments();
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

        for (int i = 0; i < this.treatments.size(); i++) {
            this.treatmentTrack.put(this.treatments.get(i).getAnimalID(), Boolean.FALSE);
        }
    }

    public void makeSchedule() {
        // schedule priority one
        int priorityFlag;
        ArrayList<Integer> tasks;
        Set<Integer> treatmentKeys = this.treatmentMap.keySet();

        priorityFlag = 1;
        tasks = this.taskPriorityMap.get(priorityFlag);

        for (Integer i: treatmentKeys) {
            Treatment treatment = this.treatmentMap.get(i);

            if (tasks.contains(treatment.getTask())) {
                Integer startHour = treatment.getStartHour();

                this.scheduleMap.put(String.valueOf(startHour), treatment);
                this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
            }
        }

        priorityFlag = 2;
        tasks = this.taskPriorityMap.get(priorityFlag);

        for (Integer i: treatmentKeys) {
            Treatment treatment = this.treatmentMap.get(i);

            if (tasks.contains(treatment.getTask())) {
                Integer startHour = treatment.getStartHour();

                if (this.scheduleMap.get(String.valueOf(startHour)) == null) {
                    this.scheduleMap.put(String.valueOf(startHour), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 1)) == null && (startHour - 1 < 24) && startHour - 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 1)) == null && (startHour + 1 < 24) && startHour + 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

            }
        }

        priorityFlag = 3;
        tasks = this.taskPriorityMap.get(priorityFlag);

        for (Integer i: treatmentKeys) {
            Treatment treatment = this.treatmentMap.get(i);

            if (tasks.contains(treatment.getTask())) {
                Integer startHour = treatment.getStartHour();

                if (this.scheduleMap.get(String.valueOf(startHour)) == null) {
                    this.scheduleMap.put(String.valueOf(startHour), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 1)) == null && (startHour - 1 < 24) && startHour - 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 1)) == null && (startHour + 1 < 24) && startHour + 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 2)) == null && (startHour - 2 < 24) && startHour - 2 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 2), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 2)) == null && (startHour + 2 < 24) && startHour + 2 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 2), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

            }
        }

        priorityFlag = 4;
        tasks = this.taskPriorityMap.get(priorityFlag);

        for (Integer i: treatmentKeys) {
            Treatment treatment = this.treatmentMap.get(i);

            if (tasks.contains(treatment.getTask())) {
                Integer startHour = treatment.getStartHour();

                if (this.scheduleMap.get(String.valueOf(startHour)) == null) {
                    this.scheduleMap.put(String.valueOf(startHour), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 1)) == null && (startHour - 1 < 24) && startHour - 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 1)) == null && (startHour + 1 < 24) && startHour + 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 2)) == null && (startHour - 2 < 24) && startHour - 2 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 2), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 2)) == null && (startHour + 2 < 24) && startHour + 2 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 2), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 3)) == null && (startHour - 3 < 24) && startHour - 3 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 3), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 3)) == null && (startHour + 3 < 24) && startHour + 3 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 3), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

            }
        }

        priorityFlag = 5;
        tasks = this.taskPriorityMap.get(priorityFlag);

        for (Integer i: treatmentKeys) {
            Treatment treatment = this.treatmentMap.get(i);

            if (tasks.contains(treatment.getTask())) {
                Integer startHour = treatment.getStartHour();

                if (this.scheduleMap.get(String.valueOf(startHour)) == null) {
                    this.scheduleMap.put(String.valueOf(startHour), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 1)) == null && (startHour - 1 < 24) && startHour - 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 1)) == null && (startHour + 1 < 24) && startHour + 1 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 1), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 2)) == null && (startHour - 2 < 24) && startHour - 2 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 2), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 2)) == null && (startHour + 2 < 24) && startHour + 2 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 2), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 3)) == null && (startHour - 3 < 24) && startHour - 3 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 3), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 3)) == null && (startHour + 3 < 24) && startHour + 3 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour + 3), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour - 4)) == null && (startHour - 4 < 24) && startHour - 4 > 0) {
                    this.scheduleMap.put(String.valueOf(startHour - 4), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

                if (this.scheduleMap.get(String.valueOf(startHour + 4)) == null && (startHour + 4 < 24) && startHour + 4 > 0) {
					
                    this.scheduleMap.put(String.valueOf(startHour + 4), treatment);
                    this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                }

            }
        }

        Set<Integer> treatmentTrackKeys = this.treatmentTrack.keySet();
        Set<String> scheduleMapKeys = this.scheduleMap.keySet();
        Set<Integer> treatmentMapKeys = this.treatmentMap.keySet();

        for (Integer trackKey: treatmentTrackKeys) {
            if (this.treatmentTrack.get(trackKey) == Boolean.FALSE) {
                for (String scheduleKey: scheduleMapKeys) {
                    if (this.scheduleMap.get(scheduleKey) == null) {
                        Treatment treatment = this.treatmentMap.get(trackKey);
                        Integer startHour = treatment.getStartHour();

                        this.scheduleMap.put(String.valueOf(startHour), treatment);
                        this.treatmentTrack.put(treatment.getAnimalID(), Boolean.TRUE);
                    }
                }
            }
        }
/**
        Set<String> map = this.scheduleMap.keySet();
        for (String key: map) {
            System.out.println(key + " -> " + this.scheduleMap.get(key));
        }
**/
    }

    public void update(int i, int n) {
		this.db.updateTime(i,n);
    }
	
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String toText() {
		String result = this.date.toString()+"\n";
        for (int i=0; i<24; i++) {
            result += ("Hour:" + i + " Tasks: ");
			if (this.scheduleMap.get(Integer.toString(i))!=null) {
				result += "Task ID:"+this.scheduleMap.get(Integer.toString(i)).getTask();
				result += " Animal ID:"+this.scheduleMap.get(Integer.toString(i)).getAnimalID();
			}
			result += "\n";
        }
		return result;
	}
	
	public void toFile() {
		try {
			File f = new File("Schedule"+date.toString()+".txt");
			FileWriter out = new FileWriter("Schedule"+date.toString()+".txt");
			out.write(toText());
			out.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

    public HashMap<String, Treatment> getSchedule() {
        return this.scheduleMap;
    }
}