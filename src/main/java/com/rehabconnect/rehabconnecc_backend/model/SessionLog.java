package com.rehabconnect.rehabconnecc_backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity // tells Spring/JPA that this is a table
public class SessionLog {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String patientId;
    private int painLevel;

    @ElementCollection
    private List<String> exercises;
    private int repsCompleted;

    public long getId() { return id; }

    public void setId(long id) { this.id = id; }

    public String getPatientId() { return patientId; }

    public void setPatientId(String patientId) { this.patientId = patientId; }

    public int getPainLevel() { return painLevel; }

    public void setPainLevel(int painLevel) { this.painLevel = painLevel; }

    public List<String> getExercises() { return exercises; }

    public void setExercises(List<String> exercises) { this.exercises = exercises; }

    public int getRepsCompleted() { return repsCompleted; }

    public void setRepsCompleted(int repsCompleted) { this.repsCompleted = repsCompleted; }
}
