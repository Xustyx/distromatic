package com.xstyx.distromatic.task;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/task")
public class TaskController {

	@RequestMapping(value="/{taskId}", method = RequestMethod.GET)
	public void runTask(@PathVariable(name="taskId") String taskId) {
		
	}
}
