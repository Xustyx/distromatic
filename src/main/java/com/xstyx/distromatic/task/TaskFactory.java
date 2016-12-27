package com.xstyx.distromatic.task;

import com.xstyx.distromatic.utils.Type;

public class TaskFactory {
	
	public Task createTask(Type workType){
		
		Task task;
		
		switch (workType) {
			case MD5:
				task = new TaskMd5();
				break;
	
			default:
				task = new Task();
				break;
			
		}
		
		return task;
	}

}
