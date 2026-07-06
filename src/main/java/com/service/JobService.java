package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Job;
import com.entity.User;
import com.repository.JobRepository;
import com.repository.UserRepository;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private UserRepository userRepository;

    
    // ADD JOB
    public Job addJob(Job job, Long recruiterId) {

        User recruiter = userRepository.findById(recruiterId)
                .orElseThrow(() -> new RuntimeException("Recruiter not found"));

        job.setRecruiter(recruiter);

        return jobRepository.save(job);
    }

    
    // GET ALL JOBS
    public List<Job> getAllJobs() {

        return jobRepository.findAll();
    }

    
    // GET JOB BY ID
    public Job getJobById(Long id) {

        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found"));
    }
}
