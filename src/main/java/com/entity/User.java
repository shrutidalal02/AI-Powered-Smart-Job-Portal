package com.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    @JsonIgnore
    private String password;

    private String role;

    // Recruiter -> Jobs
    @JsonIgnore
    @OneToMany(mappedBy = "recruiter")
    private List<Job> jobs;

    // Candidate -> Applications
    @JsonIgnore
    @OneToMany(mappedBy = "candidate")
    private List<Application> applications;

    // Candidate -> Resume
    @JsonIgnore
    @OneToOne(mappedBy = "candidate")
    private Resume resume;
}
