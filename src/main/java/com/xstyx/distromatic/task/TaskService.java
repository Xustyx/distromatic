package com.xstyx.distromatic.task;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xstyx.distromatic.utils.DateUtils;
import com.xstyx.distromatic.utils.Status;
import com.xstyx.distromatic.work.Work;
import com.xstyx.distromatic.work.WorkService;

@Service
public class TaskService {
	
	@Autowired
	private WorkService workService;
	
	private Map<String,TaskManager> tasks = new HashMap<String, TaskManager>();
	
	public Task createTask(TaskDTO taskDto){	
		TaskManager taskManager = new TaskManager();
		TaskFactory taskFactory = new TaskFactory();
		
		Work work = workService.getWork(taskDto.getWorkId());
		Task task = taskFactory.createTask(work.getWorkType());
		
		task.setPart(taskDto.getPart());
		task.setTotal(taskDto.getTotal());
		
		task.setStart(DateUtils.getDateNowString());
		task.setStatus(Status.Started);
		work.setStatus(Status.Running);
		task.setWork(work);
		
		taskManager.setTask(task);
		taskManager.setWorkService(workService);
		taskManager.setTaskService(this);
		taskManager.start();
		
		work.getTasks().add(task);
		work = workService.saveOrUpdateWork(work);
		
		tasks.put(work.getId(), taskManager);
		
		return task;	
	}
	
	public boolean stopTask(String workId){
		TaskManager taskManager;
		taskManager = tasks.get(workId);
		
		if(taskManager != null) {
			taskManager.getTask().setStatus(Status.Stopped);
			tasks.remove(workId);
			return true;
		}
		
		return false;
	}
}
