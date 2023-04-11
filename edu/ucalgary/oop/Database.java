package edu.ucalgary.oop;

import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Connection dbConnect;  // The database connection object
    private ResultSet results;     // The result set object used for database queries
    private ArrayList<Coyote> coyotes;     // The list of Coyote objects retrieved from the database
    private ArrayList<Beaver> beavers;     // The list of Beaver objects retrieved from the database
    private ArrayList<Fox> foxes;         // The list of Fox objects retrieved from the database
    private ArrayList<Raccoon> raccoons;   // The list of Raccoon objects retrieved from the database
    private ArrayList<Porcupine> porcupines;  // The list of Porcupine objects retrieved from the database
    private ArrayList<Task> tasks;        // The list of Task objects retrieved from the database
    private ArrayList<Treatment> treatments; // The list of Treatment objects retrieved from the database

    /**
     * Constructs a new Database object.
     */
    public Database() {
    }

    /**
     * Creates a connection to the MySQL database.
     */
    public void createConnection() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/EWR", "oop", "password");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTime(Integer newStartHour, Integer id) {
        try {

            PreparedStatement myStmt = dbConnect.prepareStatement("UPDATE Treatments SET StartHour=? WHERE TreatmentID=?");
            myStmt.setInt(1, newStartHour);
            myStmt.setInt(2, id);

            myStmt.executeUpdate();
            myStmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Queries the database for all animals and stores them in separate lists based on their species.
     */
    public void selectAnimals() {
        try {
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM animals");
            this.coyotes = new ArrayList<Coyote>();
            this.beavers = new ArrayList<Beaver>();
            this.foxes = new ArrayList<Fox>();
            this.raccoons = new ArrayList<Raccoon>();
            this.porcupines = new ArrayList<Porcupine>();

            while (results.next()) {
                if (results.getString("AnimalSpecies").equals("coyote")) {
                    Coyote coyote_new = new Coyote(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    this.coyotes.add(coyote_new);
                }
                if (results.getString("AnimalSpecies").equals("fox")) {
                    Fox fox_new = new Fox(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    this.foxes.add(fox_new);
                }
                if (results.getString("AnimalSpecies").equals("beaver")) {
                    Beaver beaver_new = new Beaver(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    this.beavers.add(beaver_new);
                }
                if (results.getString("AnimalSpecies").equals("raccoon")) {
                    Raccoon racoon_new = new Raccoon(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    this.raccoons.add(racoon_new);
                }
                if (results.getString("AnimalSpecies").equals("porcupine")) {
                    Porcupine porcupine_new = new Porcupine(results.getInt("animalID"), results.getString("AnimalNickname"), results.getString("AnimalSpecies"));
                    this.porcupines.add(porcupine_new);
                }
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**

     Returns the list of Coyotes in the collection.
     @return ArrayList<Coyote> The list of Coyotes in the collection.
     */
    public ArrayList<Coyote> getCoyotes() {
        return this.coyotes;
    }
    /**

     Returns the list of Beavers in the collection.
     @return ArrayList<Beaver> The list of Beavers in the collection.
     */
    public ArrayList<Beaver> getBeavers() {
        return this.beavers;
    }
    /**

     Returns the list of Foxes in the collection.
     @return ArrayList<Fox> The list of Foxes in the collection.
     */
    public ArrayList<Fox> getFoxes() {
        return this.foxes;
    }
    /**

     Returns the list of Raccoons in the collection.
     @return ArrayList<Raccoon> The list of Raccoons in the collection.
     */
    public ArrayList<Raccoon> getRaccoons() {
        return this.raccoons;
    }
    /**

     Returns the list of Porcupines in the collection.
     @return ArrayList<Porcupine> The list of Porcupines in the collection.
     */
    public ArrayList<Porcupine> getPorcupines() {
        return this.porcupines;
    }
    /**
     * Queries the database for all tasks and stores them in an array list called tasks
     */
    public ArrayList<Task> selectTasks() {
        this.tasks = new ArrayList<Task>();

        try {
            Statement myStmt = dbConnect.createStatement();

            results = myStmt.executeQuery("SELECT * FROM TASKS;");

            while (results.next()) {
                Task task_new = new Task(results.getInt("TaskID"), results.getString("Description"), results.getInt("Duration"), results.getInt("MaxWindow"));
                this.tasks.add(task_new);

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.tasks;

    }
    /**
     * Queries the database for all treatments and stores them in an arraylist called treatments
     */
    public ArrayList<Treatment> selectTreatments() {
        this.treatments = new ArrayList<Treatment>();

        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM TREATMENTS ORDER BY StartHour;");

            while (results.next()) {
                Treatment treatment_new = new Treatment(results.getInt("TreatmentID"), results.getInt("animalID"), results.getInt("taskID"), results.getInt("startHour"));
                this.treatments.add(treatment_new);

                //System.out.println("Print Treatments: " + results.getInt("animalID") + ", " + results.getString("taskID") + ", " + results.getString("startHour"));

            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this.treatments;

    }
}