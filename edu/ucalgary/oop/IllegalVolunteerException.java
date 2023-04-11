package edu.ucalgary.oop;
/**
 The IllegalVolunteerException is an exception that is thrown when a volunteer does not meet certain requirements.
 */
public class IllegalVolunteerException extends Exception {

	/**
	 Constructs a new IllegalVolunteerException with the given error message.
	 @param message the error message for this exception.
	 */
	public IllegalVolunteerException(String message) {
		super(message);
	}
}