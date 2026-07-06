package com.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.entity.Resume;
import com.service.ResumeService;

@RestController
@RequestMapping("/resume")
@CrossOrigin("*")
public class ResumeController {

    @Autowired
    private ResumeService resumeService;


    //1. UPLOAD RESUME API
    @PostMapping("/upload")
    public Resume uploadResume(@RequestParam MultipartFile file,
                               @RequestParam Long candidateId) throws IOException {

        return resumeService.uploadResume(file, candidateId);
    }


    //2. GET RESUME BY CANDIDATE ID
    @GetMapping("/{candidateId}")
    public Resume getResumeByCandidate(@PathVariable Long candidateId) {

        return resumeService.getResumeByCandidate(candidateId);
    }
    
    //3. View Resume
//    @GetMapping("/view/{resumeId}")
//    public ResponseEntity<Resource> viewResume(@PathVariable Long resumeId) throws IOException {
//
//        Resume resume = resumeService.getResumeById(resumeId);
//
//        Path path = Paths.get(resume.getFilePath());
//
//        Resource resource = new UrlResource(path.toUri());
// 		return ResponseEntity.ok()
//    	.header(HttpHeaders.CONTENT_DISPOSITION,
//            "inline; filename=\"" + resource.getFilename() + "\"")
//    	.contentType(MediaType.APPLICATION_PDF)
//    	.body(resource);
    
    
//        return ResponseEntity.ok()
//                .header(HttpHeaders.CONTENT_DISPOSITION,
//                        "inline; filename=\"" + resource.getFilename() + "\"")
//                .body(resource);
//    }
}
