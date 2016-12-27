package com.xstyx.distromatic.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/task")
public class TaskController {
	
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createTask(@RequestBody TaskDTO taskDto) {
		Task task;
		
		task = taskService.createTask(taskDto);
		
		return ResponseEntity.ok(task);
	}
}
