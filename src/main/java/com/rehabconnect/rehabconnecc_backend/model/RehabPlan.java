package com.rehabconnect.rehabconnecc_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

//making this class using LOMBOK java libraray to reduce bioler point. Only doing to practice
@Entity
@Data
public class RehabPlan {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //primary key to identify each row in the database
    private Long id;
   //used to fetch/update the plan for specific patient
    private String patientId;
    private List<String> exercises;
    private String goals;


}
