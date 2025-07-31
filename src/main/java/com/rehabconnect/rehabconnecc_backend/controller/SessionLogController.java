package com.rehabconnect.rehabconnecc_backend.controller;

import com.rehabconnect.rehabconnecc_backend.model.SessionLog;
import com.rehabconnect.rehabconnecc_backend.service.SessionLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SessionLogController {

    private final SessionLogService sessionLogService;

    @Autowired
    public SessionLogController(SessionLogService sessionLogService) {
        this.sessionLogService = sessionLogService;
    }

    // POST /api/log — save a new rehab session
    @PostMapping("/log")
    public SessionLog logSession(@RequestBody SessionLog sessionLog) {
        return sessionLogService.saveSessionLog(sessionLog);
    }

    // GET /api/progress/{patientId} — get all logs for a patient
    @GetMapping("/progress/{patientId}")
    public List<SessionLog> getProgress(@PathVariable String patientId) {
        return sessionLogService.getLogsByPatientId(patientId);
    }
}
