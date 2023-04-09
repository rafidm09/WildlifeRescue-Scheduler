package edu.ucalgary.oop;
import java.util.ArrayList;

public class Hour {
	private ArrayList<Task> tasks = new ArrayList<Task>;
	private int tSpent=0;
	private int tAvail=60;
	private boolean backup=false;
	/**Adds task and updates time values**/
	public void addTask(Task t) {
		int t = t.getTime;
		this.tSpent+=t;
		this.tAvail-=t;
		if (this.tAvail<0) {
			if (backup) {
				this.tSpent-=t;
				this.tAvail+=t;
				//throw unavailable exception
			} else {
				//backup handler here
			}
		}
		this.tasks.add(t);
	}
	/**Removes task at index and updates time values**/
	public void removeTask(int i) {
		t=this.tasks.get(i).getTime;
		this.tasks.remove(i);
		this.tSpent-=t;
		this.tAvail+=t;
	}
	/**Getters**/
	public Task getTask(int i) {return this.tasks.get(i);}
	public ArrayList<Task> getTasks() {return this.tasks;}
	public int[] getIme() {return {this.tSpent, this.tAvail};}
	public boolean getBackup() {return this.backup;}
}