package edu.ucalgary.oop;
import java.util.ArrayList;

public class Hour {
	private ArrayList<Task> tasks = new ArrayList<Task>();
	private int timeSpent=0;
	private int timeAvailable=60;
	private boolean backup=false;
	/**Adds task and updates time values**/
	public void addTask(Task t) {
		int time = t.getDuration();
		this.timeSpent+=time;
		this.timeAvailable-=time;
		if (this.timeAvailable<0) {
			if (backup) {
				this.timeSpent-=time;
				this.timeAvailable+=time;
				//throw unavailable exception
			} else {
				//backup handler here
			}
		}
		this.tasks.add(t);
	}
	/**Removes task at index and updates time values**/
	public void removeTask(int i) {
		int time=this.tasks.get(i).getDuration();
		this.tasks.remove(i);
		this.timeSpent-=time;
		this.timeAvailable+=time;
	}
	/**Getters**/
	public Task getTask(int i) {return this.tasks.get(i);}
	public ArrayList<Task> getTasks() {return this.tasks;}
	public int[] getIme() {return new int[]{this.timeSpent, this.timeAvailable};}
	public boolean getBackup() {return this.backup;}
}