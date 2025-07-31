package com.rehabconnect.rehabconnecc_backend.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;


//Refactoring for practice sake using the Builder Pattern for practice.
// Also makes sense with this class because of so many fields and easier to READ
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
    public SessionLog() {}// for no Arg for JPA

    private SessionLog(Builder builder) {
        this.id = builder.id;
        this.patientId = builder.patientId;
        this.painLevel = builder.painLevel;
        this.exercises = builder.exercises;
        this.repsCompleted = builder.repsCompleted;
    }

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

    public static class Builder {
        private long id;
        private String patientId;
        private int painLevel;
        private List<String> exercises;
        private int repsCompleted;

        public Builder id(long id) {
            this.id = id;
            return this;
        }
        public Builder patientId(String patientId) {
            this.patientId = patientId;
            return this;
        }
        public Builder painLevel(int painLevel) {
            this.painLevel = painLevel;
            return this;
        }
        public Builder exercises(List<String> exercises) {
            this.exercises = exercises;
            return this;
        }

        public Builder repsCompleted(int repsCompleted) {
            this.repsCompleted = repsCompleted;
            return this;
        }

        public SessionLog build() {
            return new SessionLog(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SessionLog that)) return false;
        return getId() == that.getId() && getPainLevel() == that.getPainLevel() && getRepsCompleted() == that.getRepsCompleted() && Objects.equals(getPatientId(), that.getPatientId()) && Objects.equals(getExercises(), that.getExercises());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPatientId(), getPainLevel(), getExercises(), getRepsCompleted());
    }

    @Override
    public String toString() {
        return "SessionLog{" +
                "id=" + id +
                ", patientId='" + patientId + '\'' +
                ", painLevel=" + painLevel +
                ", exercises=" + exercises +
                ", repsCompleted=" + repsCompleted +
                '}';
    }
}
