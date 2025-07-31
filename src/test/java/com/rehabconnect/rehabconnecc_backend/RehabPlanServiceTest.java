package com.rehabconnect.rehabconnecc_backend;

import com.rehabconnect.rehabconnecc_backend.model.RehabPlan;
import com.rehabconnect.rehabconnecc_backend.repository.RehabPlanRepository;
import com.rehabconnect.rehabconnecc_backend.service.RehabPlanService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RehabPlanServiceTest {
    private RehabPlanRepository mockRepo;
    private RehabPlanService service;

    @BeforeEach
    void setUp() {
        mockRepo = mock(RehabPlanRepository.class);
        service = new RehabPlanService(mockRepo);
    }

    @Test
    void testGetPlanByPatientId() {
        RehabPlan mockPlan = new RehabPlan();
        mockPlan.setPatientId("123");
        when(mockRepo.findByPatientId("123")).thenReturn(Optional.of(mockPlan));

        Optional<RehabPlan> result = service.getPlanByPatientId("123");

        assertEquals("123", result.get().getPatientId());
        verify(mockRepo).findByPatientId("123");
    }
}

