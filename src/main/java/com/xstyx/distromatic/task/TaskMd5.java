package com.xstyx.distromatic.task;

import com.xstyx.distromatic.utils.Status;

public class TaskMd5 {
	
	private Task task;
	private int pos;
	private int total;
	private String hash;
	
	private final String charset = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public TaskMd5(Task task){
		setTask(task);
	}
	
	public String run(){
		int i = pos;
		
		while(task.getWork().getStatus().equals(Status.Completed) || i < 1){
			
		}
		
		return "a";
	}
	
	public String getWord(long pos){
		
		int base = charset.length();
		long q = pos;
		String word = "";
		
		while(q != 0){
			word = charset.charAt((int)(q % base)) + word;
			q = q / base;
		}

		return word;
	} 
	
	
	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public int getPos() {
		return pos;
	}
	
	public void setPos(int pos) {
		this.pos = pos;
	}
	
	public int getTotal() {
		return total;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public String getHash() {
		return hash;
	}
	
	public void setHash(String hash) {
		this.hash = hash;
	}
}
