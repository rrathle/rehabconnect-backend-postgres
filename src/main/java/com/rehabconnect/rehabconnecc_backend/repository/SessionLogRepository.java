package com.rehabconnect.rehabconnecc_backend.repository;

import com.rehabconnect.rehabconnecc_backend.model.SessionLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
// class extends and provides crud operations for JPA by extending
public interface SessionLogRepository extends JpaRepository<SessionLog, Long> {
    List<SessionLog> findByPatientId(String patientId);
    //custom query method crreates  SELECT * FROM session_log WHERE patient_id = :patientId
}
