package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Application;
import com.service.ApplicationService;

@RestController
@RequestMapping("/applications")
@CrossOrigin("*")

public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@PostMapping("/apply")
	public Application applyForJob(@RequestParam Long candidateId, @RequestParam Long jobId )
	{
		return applicationService.applyForJob(candidateId,jobId);
	}  
	
	@PutMapping("/status")
	public Application updateApplicationStatus(
	        @RequestParam Long applicationId,
	        @RequestParam String status) {

	    return applicationService
	            .updateApplicationStatus(applicationId, status);
	}

}
