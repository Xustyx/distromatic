package com.xstyx.distromatic.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.xstyx.distromatic.task.Task;
import com.xstyx.distromatic.task.TaskDTO;
@Service
public class DistroService {
	
	public Task sendTask(TaskDTO taskDto, String url){
		RestTemplate restTemplate = new RestTemplate();
		Task task;
		
		task = restTemplate.postForObject(url, taskDto, Task.class);
		
		return task;
	}
	
	public List<Task> distributeTask(String workId){
		List<Task> tasks = new ArrayList<Task>();
		TaskDTO taskDto = new TaskDTO();
		long resources = getResources();
		
		taskDto.setWorkId(workId);
		
		for(int i = 0; i < resources; i++){
			taskDto.setPart(i);
			taskDto.setTotal(resources);
			tasks.add(sendTask(taskDto, "http://localhost:8080/task"));
		}
		
		return tasks;
	}
	
	public long getResources(){
		return 4;
	}

}
