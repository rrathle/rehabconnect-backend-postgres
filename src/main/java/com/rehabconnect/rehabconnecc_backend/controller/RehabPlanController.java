package com.rehabconnect.rehabconnecc_backend.controller;

import com.rehabconnect.rehabconnecc_backend.model.RehabPlan;
import com.rehabconnect.rehabconnecc_backend.service.RehabPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RehabPlanController {

    private final RehabPlanService rehabPlanService;

    @Autowired
    public RehabPlanController(RehabPlanService rehabPlanService) {
        this.rehabPlanService = rehabPlanService;
    }

    // GET /api/plan/{patientId}
    @GetMapping("/plan/{patientId}")
    public Optional<RehabPlan> getPlan(@PathVariable String patientId) {
        return rehabPlanService.getPlanByPatientId(patientId);
    }

    // POST /api/plan
    @PostMapping("/plan")
    public RehabPlan saveOrUpdatePlan(@RequestBody RehabPlan plan) {
        return rehabPlanService.saveOrUpdatePlan(plan);
    }

    //Plan /api/plan/{patientId}
    @PutMapping("/plan/{patientId}")
    public RehabPlan updatePlan(@PathVariable String patientId, @RequestBody RehabPlan updatedPlan) {
        updatedPlan.setPatientId(patientId);
        return rehabPlanService.saveOrUpdatePlan(updatedPlan);
    }


}