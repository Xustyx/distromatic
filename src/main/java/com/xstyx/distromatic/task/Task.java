package com.xstyx.distromatic.task;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.xstyx.distromatic.utils.Status;
import com.xstyx.distromatic.work.Work;

@Document
public class Task {
	
	@Id
	private String id;
	private Work work;
	private Status status;
	private LocalDateTime start;
	private LocalDateTime end;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Work getWork() {
		return work;
	}
	
	public void setWork(Work work) {
		this.work = work;
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
	
}
