package com.rehabconnect.rehabconnecc_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long basicId;
    private String name;
    private String email;

    public Patient(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public Patient() {}

    public Long getBasicId() {
        return basicId;
    }

    public void setBasicId(Long basicId) {
        this.basicId = basicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return Objects.equals(getBasicId(), patient.getBasicId()) && Objects.equals(getName(), patient.getName()) && Objects.equals(getEmail(), patient.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBasicId(), getName(), getEmail());
    }
}
