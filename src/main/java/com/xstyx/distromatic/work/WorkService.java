package com.xstyx.distromatic.work;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xstyx.distromatic.task.Task;
import com.xstyx.distromatic.utils.DateUtils;
import com.xstyx.distromatic.utils.DistroService;
import com.xstyx.distromatic.utils.Status;

@Service
public class WorkService {
	
	@Autowired
	private WorkRepository workRepository;
	
	@Autowired
	private DistroService distroService;
	
	public Work createWork(WorkDTO workDto) {
		Work work = new Work();
		
		work.setStart(DateUtils.getDateNowString());
		work.setStatus(Status.Started);
		
		work.setWorkType(workDto.getType());
		work.setArguments(workDto.getArguments());
		
		work = workRepository.save(work);
		
		distroService.distributeTask(work.getId());
		
		return work;
	}
	
	public Work getWork(String id) {
		return workRepository.findOne(id);
	}

	public List<Work> getWorks() {
		return workRepository.findAll();
	}
	
	public boolean checkAllTaskFinished(Work work){
		
		for(Task task : work.getTasks()){
			if(!Status.Finished.equals(task.getStatus())){
				return false;
			}
		}
		
		return true;
	}
	
	public Work saveOrUpdateWork(Work work){
		return workRepository.save(work);
	}

}
