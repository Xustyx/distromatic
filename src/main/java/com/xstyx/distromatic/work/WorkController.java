package com.xstyx.distromatic.work;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/work")
public class WorkController {
	
	@Autowired
	private WorkService workService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> createWork(@RequestBody WorkDTO workDto){
		Work work;
		
		work = workService.createWork(workDto);
		
		return ResponseEntity.ok(work);
	}
	
	@RequestMapping(value="/{workId}", method = RequestMethod.GET)
	public ResponseEntity<?> getWork(@PathVariable("workId") String workId){
		Work work;
		
		work = workService.getWork(workId);
		
		if (work == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.ok(work);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getWorks(){
		List<Work> works = workService.getWorks();
		
		return ResponseEntity.ok(works);
	}
}
