package com.rehabconnect.rehabconnecc_backend.service;

import com.rehabconnect.rehabconnecc_backend.model.SessionLog;
import com.rehabconnect.rehabconnecc_backend.repository.SessionLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionLogService {

    private final SessionLogRepository sessionLogRepository;

    // Constructor injection
    public SessionLogService(SessionLogRepository sessionLogRepository) {
        this.sessionLogRepository = sessionLogRepository;
    }

    // Save a new session log
    public SessionLog saveSessionLog(SessionLog log) {
        return sessionLogRepository.save(log);
    }

    // Get all logs for a patient
    public List<SessionLog> getLogsByPatientId(String patientId) {
        return sessionLogRepository.findByPatientId(patientId);
    }
}

