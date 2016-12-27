package com.xstyx.distromatic.task;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.xstyx.distromatic.utils.Status;
import com.xstyx.distromatic.work.Work;

public class Task {
	
	@DBRef
	@JsonIgnore
	private Work work;
	private Status status;
	private String start;
	private String end;
	private long part;
	private long total;
	
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

	public long getPart() {
		return part;
	}

	public void setPart(long part) {
		this.part = part;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}	
}
