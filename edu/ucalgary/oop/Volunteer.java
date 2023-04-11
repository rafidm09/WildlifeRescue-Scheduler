package edu.ucalgary.oop;

/**

 The Volunteer interface defines the methods that a volunteer in the zoo must implement.
 */
public interface Volunteer {

	/**
	 Indicates whether this volunteer can be used as a backup volunteer.
	 @return true if this volunteer can be used as a backup volunteer, false otherwise.
	 */
	public boolean backupVolunteer();
}
