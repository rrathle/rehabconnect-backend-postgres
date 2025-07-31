package com.rehabconnect.rehabconnecc_backend.service;

import com.rehabconnect.rehabconnecc_backend.model.RehabPlan;
import com.rehabconnect.rehabconnecc_backend.repository.RehabPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RehabPlanService {

    private final RehabPlanRepository rehabPlanRepository;

    @Autowired
    public RehabPlanService(RehabPlanRepository rehabPlanRepository) {
        this.rehabPlanRepository = rehabPlanRepository;
    }

    public Optional<RehabPlan> getPlanByPatientId(String patientId) {
        return rehabPlanRepository.findByPatientId(patientId);
    }

    public RehabPlan saveOrUpdatePlan(RehabPlan plan) {
        Optional<RehabPlan> existingPlan = rehabPlanRepository.findByPatientId(plan.getPatientId());

        if (existingPlan.isPresent()) {
            RehabPlan toUpdate = existingPlan.get();
            toUpdate.setExercises(plan.getExercises());
            toUpdate.setGoals(plan.getGoals());
            return rehabPlanRepository.save(toUpdate);
        } else {
            return rehabPlanRepository.save(plan);
        }
    }
}
