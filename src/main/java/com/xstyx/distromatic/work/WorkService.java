package com.xstyx.distromatic.work;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkService {
	
	@Autowired
	private WorkRepository workRepository;
	
	public Work createWork(WorkDTO workDto) {
		
	}
	
	public Work getWork(String id) {
		return workRepository.findOne(id);
	}

	public List<Work> getWorks() {
		return workRepository.findAll();
	}

}
