package com.xstyx.distromatic.task;

public class TaskManager {
	
	private Task task;
	
	public TaskManager(Task task) {
		setTask(task);
	}
	
	
	public void run(){
		
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	
}
