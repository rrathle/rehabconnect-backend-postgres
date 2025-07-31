package com.rehabconnect.rehabconnecc_backend;

import com.rehabconnect.rehabconnecc_backend.model.SessionLog;
import com.rehabconnect.rehabconnecc_backend.repository.SessionLogRepository;
import com.rehabconnect.rehabconnecc_backend.service.SessionLogService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

public class SessionLogServiceTest {
    private SessionLogRepository mockRepo;
    private SessionLogService service;

    @BeforeEach
    void setUp() {
        mockRepo = mock(SessionLogRepository.class);
        service = new SessionLogService(mockRepo);  // Assuming constructor injection
    }

    @Test
    void testSaveSessionLog() {
        // Arrange
        SessionLog mockLog = new SessionLog.Builder()
                .patientId("abc-123")
                .painLevel(4)
                .exercises(List.of("Bridge", "Bird Dog"))
                .repsCompleted(20)
                .build();

        when(mockRepo.save(any(SessionLog.class))).thenReturn(mockLog);

        // Act
        SessionLog result = service.saveSessionLog(mockLog);

        // Assert
        ArgumentCaptor<SessionLog> captor = ArgumentCaptor.forClass(SessionLog.class);
        verify(mockRepo).save(captor.capture());

        SessionLog saved = captor.getValue();
        assertEquals("abc-123", saved.getPatientId());
        assertEquals(4, saved.getPainLevel());
        assertEquals(20, saved.getRepsCompleted());

        assertSame(mockLog, result); // Optional: ensure return is the same mock
    }
}
