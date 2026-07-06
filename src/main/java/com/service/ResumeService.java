package com.service;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Resume;
import com.entity.User;
import com.repository.ResumeRepository;
import com.repository.UserRepository;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    @Autowired
    private UserRepository userRepository;


    // UPLOAD RESUME
    public Resume uploadResume(MultipartFile file, Long candidateId) throws IOException {

        //1. Find candidate
        User candidate = userRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

     // Create uploads folder path
        String uploadDir = System.getProperty("user.dir") + "/uploads/";

        // Create directory object
        File directory = new File(uploadDir);

        // Create uploads folder if not exists
        if (!directory.exists()) {
            directory.mkdir();
        }

        // Original filename
        String fileName = file.getOriginalFilename();

        // Complete file path
        String filePath = uploadDir + fileName;

        // Save file
        file.transferTo(new File(filePath));

        // Create resume object
        Resume resume = new Resume();

        resume.setFileName(fileName);

        resume.setFilePath(filePath);

        resume.setCandidate(candidate);

        // Save in DB
        return resumeRepository.save(resume);
    }


    //2. GET RESUME BY CANDIDATE ID
    public Resume getResumeByCandidate(Long candidateId) {

        User candidate = userRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        return candidate.getResume();
    }
    
    //3. View Resume
//    public Resume getResumeById(Long resumeId) {
//
//        return resumeRepository.findById(resumeId)
//                .orElseThrow(() -> new RuntimeException("Resume not found"));
//    }
}
