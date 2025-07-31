package com.rehabconnect.rehabconnecc_backend.repository;

import com.rehabconnect.rehabconnecc_backend.model.RehabPlan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RehabPlanRepository extends JpaRepository<RehabPlan ,Long> {
    Optional<RehabPlan> findByPatientId(String patientId);
}
