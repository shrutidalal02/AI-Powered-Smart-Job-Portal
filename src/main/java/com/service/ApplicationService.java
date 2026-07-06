package com.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Application;
import com.entity.Job;
import com.entity.User;
import com.repository.ApplicationRepository;
import com.repository.JobRepository;
import com.repository.UserRepository;

@Service
public class ApplicationService {

	@Autowired
	ApplicationRepository applicationRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JobRepository jobRepository;
	
	// 1.Apply for job:
	public Application applyForJob(Long candidateId, Long jobId)
	{
		//Find Candidate:
		User candidate = userRepository.findById(candidateId)
				.orElseThrow( () -> new RuntimeException("Candidate not found"));
		
		//Find Job:
		Job job = jobRepository.findById(jobId)
						.orElseThrow( () -> new RuntimeException("Job not found"));
		
		//Create application object:
		Application application=new Application();
		
		application.setCandidate(candidate);
		
		application.setJob(job);
		
		application.setAppliedDate(LocalDate.now());
		
		application.setStatus("Applied");
		
		//Save application;
		return applicationRepository.save(application);
		}
	
	//2. UPDATE APPLICATION STATUS : For example - Selected or Rejected 
	public Application updateApplicationStatus(Long applicationId,
	                                           String status) {

	    Application application = applicationRepository.findById(applicationId)
	            .orElseThrow(() -> new RuntimeException("Application not found"));

	    application.setStatus(status);

	    return applicationRepository.save(application);
	}
	
}




