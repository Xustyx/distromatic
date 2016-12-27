package com.xstyx.distromatic.work;

import java.util.Map;

import com.xstyx.distromatic.utils.Type;

public class WorkDTO {
	private Type type;
	private Map<String, Object> arguments;
	
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Map<String, Object> getArguments() {
		return arguments;
	}
	public void setArguments(Map<String, Object> arguments) {
		this.arguments = arguments;
	}
}
