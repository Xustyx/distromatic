package com.xstyx.distromatic.work;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.annotation.Id;

import com.xstyx.distromatic.task.Task;
import com.xstyx.distromatic.utils.Status;
import com.xstyx.distromatic.utils.Type;

public class Work {

	@Id
	private String id;
	private List<Task> tasks = new ArrayList<Task>();
	private Status status;
	private String start;
	private String end;
	private Type workType;
	private Map<String, Object> arguments;
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
	
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public Type getWorkType() {
		return workType;
	}

	public void setWorkType(Type workType) {
		this.workType = workType;
	}

	public Map<String, Object> getArguments() {
		return arguments;
	}

	public void setArguments(Map<String, Object> arguments) {
		this.arguments = arguments;
	}

	public Object getResult() {
		return result;
	}
	
	public void setResult(Object result) {
		this.result = result;
	}
	
}
