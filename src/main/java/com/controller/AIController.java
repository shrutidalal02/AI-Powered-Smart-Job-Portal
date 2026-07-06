package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.service.AIService;

@RestController
@RequestMapping("/ai")
@CrossOrigin("*")
public class AIController {

    @Autowired
    private AIService aiService;


    @PostMapping("/skills")
    public String extractSkills(@RequestBody String resumeText) {

        return aiService.extractSkills(resumeText);
    }
}