package com.xstyx.distromatic.task;

import com.xstyx.distromatic.utils.DateUtils;
import com.xstyx.distromatic.utils.IRunnable;
import com.xstyx.distromatic.utils.Status;
import com.xstyx.distromatic.work.Work;
import com.xstyx.distromatic.work.WorkService;

public class TaskManager extends Thread implements IRunnable  {
	
	private WorkService workService;
	private TaskService taskService;
	private Task task;
	
	public TaskManager() {}
	
	public void run(){
		switch (this.task.getWork().getWorkType()) {
			case MD5:
				this.md5Handler();
				break;
	
			default:
				break;
		}
	}
	
	private void md5Handler(){
		TaskMd5 taskMd5 = (TaskMd5)(task);
		String hash = (String)task.getWork().getArguments().get(TaskMd5.HASH_KEY);
		String charset = (String)task.getWork().getArguments().get(TaskMd5.CHARSET_KEY);
		
		if(charset != null) {
			taskMd5.setCharset(charset);
		}
		
		if(hash != null){
			taskMd5.setHash(hash);
			taskMd5.run(this);
		} else {
			this.onFinish();
		}
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
	public WorkService getWorkService() {
		return workService;
	}

	public void setWorkService(WorkService workService) {
		this.workService = workService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	private void onEnd(){
		Task task = this.task;
		Work work = task.getWork();
		String time = DateUtils.getDateNowString();
		
		task.setEnd(time);
		work.setEnd(time);
		
		workService.saveOrUpdateWork(work);
	}

	@Override
	public void onComplete(Object result) {
		Task task = this.task;
		Work work = task.getWork();
		
		work.setResult(result);	
		
		task.setStatus(Status.Completed);
		work.setStatus(Status.Completed);
		
		taskService.stopTask(work.getId());
		
		this.onEnd();
	}

	@Override
	public void onFinish() {
		Task task = this.task;
		Work work = task.getWork();
		
		task.setStatus(Status.Finished);
		
		if(workService.checkAllTaskFinished(work)){
			work.setStatus(Status.Finished);
		}
		
		this.onEnd();
	}
}
