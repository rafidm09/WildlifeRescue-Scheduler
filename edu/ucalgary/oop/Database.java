package edu.ucalgary.oop;


import java.sql.*;
import java.util.ArrayList;


public class Database {

    private Connection dbConnect;
    private ResultSet results;
    /**
     * Constructor for the Database class.
     */
    public Database() {
    }

    /**
     * Establishes a connection to the database.
     */
    public void createConnection() {

        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Retrieves all animals from the database and stores them in their respective ArrayLists
     * (coyotes, beavers, foxes, racoons, and porcupines).
     */
    public  void selectAnimals() {

        try {
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM animals");

            ArrayList<Coyote> coyotes = new ArrayList<Coyote>();
            ArrayList<Beaver> beavers = new ArrayList<Beaver>();
            ArrayList<Fox> foxes = new ArrayList<Fox>();
            ArrayList<Raccoon> racoons = new ArrayList<Raccoon>();
            ArrayList<Porcupine> porcupines = new ArrayList<Porcupine>();

            while (results.next()) {
                if (results.getString("AnimalSpecies").equals("coyote")) {
                    Coyote coyote_new = new Coyote(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    coyotes.add(coyote_new);
                }
                if (results.getString("AnimalSpecies").equals("fox")) {
                    Fox fox_new = new Fox(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    foxes.add(fox_new);
                }
                if (results.getString("AnimalSpecies").equals("beaver")) {
                    Beaver beaver_new = new Beaver(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    beavers.add(beaver_new);
                }
                if (results.getString("AnimalSpecies").equals("raccoon")) {
                    Raccoon racoon_new = new Raccoon(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    racoons.add(racoon_new);
                }
                if (results.getString("AnimalSpecies").equals("porcupine")) {
                    Porcupine porcupine_new = new Porcupine(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    porcupines.add(porcupine_new);
                }

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }


    /**
     * Retrieves all tasks from the database and stores them in an ArrayList.
     * @return an ArrayList of Task objects
     */
    public ArrayList<Task> selectTasks() {
        ArrayList<Task> tasks = new ArrayList<Task>();

        try {
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM TASKS;");

            while (results.next()) {
                Task task_new = new Task(results.getInt("TaskID"), results.getString("Description"), results.getInt("Duration"), results.getInt("MaxWindow"));
                tasks.add(task_new);

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return tasks;

    }

    /**
     * Retrieves all treatments from the database and stores them in an ArrayList.
     * @return an ArrayList of Treatment objects
     */
    public ArrayList<Treatment> selectTreatments() {
        ArrayList<Treatment> treatments = new ArrayList<Treatment>();

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM TREATMENTS ORDER BY StartHour;");

            while (results.next()) {
                Treatment treatment_new = new Treatment(results.getInt("animalID"), results.getInt("taskID"), results.getInt("startHour"));
                treatments.add(treatment_new);

                System.out.println("Print Treatments: " + results.getInt("animalID") + ", " + results.getString("taskID") + ", " + results.getString("startHour"));

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return treatments;

    }
}