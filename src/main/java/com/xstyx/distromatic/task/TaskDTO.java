package com.xstyx.distromatic.task;

public class TaskDTO {
	private String workId;
	private long part;
	private long total;
	
	public String getWorkId() {
		return workId;
	}

	public void setWorkId(String workId) {
		this.workId = workId;
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
