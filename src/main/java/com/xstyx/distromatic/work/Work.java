package com.xstyx.distromatic.work;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.xstyx.distromatic.task.Task;
import com.xstyx.distromatic.utils.Status;

@Document
public class Work {

	@Id
	private String id;
	private List<Task> tasks;
	private Status status;
	private LocalDateTime start;
	private LocalDateTime end;
	private WorkType workType;
	private Object result;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public List<Task> getTasks() {
		return tasks;
	}
	
	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public LocalDateTime getStart() {
		return start;
	}
	
	public void setStart(LocalDateTime start) {
		this.start = start;
	}
	
	public LocalDateTime getEnd() {
		return end;
	}
	
	public void setEnd(LocalDateTime end) {
		this.end = end;
	}
	
	public WorkType getWorkType() {
		return workType;
	}

	public void setWorkType(WorkType workType) {
		this.workType = workType;
	}

	public Object getResult() {
		return result;
	}
	
	public void setResult(Object result) {
		this.result = result;
	}
	
}
