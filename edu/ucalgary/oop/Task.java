package edu.ucalgary.oop;

public class Task {
	private String description;
	private String animal;
	private int time;
	Task(String desc, String ani, int t) {
		this.description=desc;
		this.animal=ani;
		this.time=t;
	}
	/**Getters**/
	public String getDescription() {return thhis.description;}
	public String getAnimal() {return this.animal;}
	public int getTime() {return this.time;}
	/**Setters**/
	public void setDescription(String desc) {this.description=desc;}
	public void setAnimal(String ani) {this.animal=ani;}
	public void setTime(int t) {this.time=t;}
}