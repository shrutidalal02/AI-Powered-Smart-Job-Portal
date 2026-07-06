package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.entity.Job;
import com.service.JobService;

@RestController
@RequestMapping("/jobs")
@CrossOrigin("*")
public class JobController {

    @Autowired
    private JobService jobService;

    
    // ADD JOB API
    @PostMapping("/{recruiterId}")
    public Job addJob(@RequestBody Job job,
                       @PathVariable Long recruiterId) {

        return jobService.addJob(job, recruiterId);
    }

    
    // GET ALL JOBS API
    @GetMapping
    public List<Job> getAllJobs() {

        return jobService.getAllJobs();
    }

    
    // GET JOB BY ID API
    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id) {

        return jobService.getJobById(id);
    }
}
