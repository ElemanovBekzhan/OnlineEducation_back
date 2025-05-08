package org.education.onlneeducation.service;


import org.education.onlneeducation.models.dto.AssignmentRequestDTO;
import org.education.onlneeducation.models.dto.AssignmentResponseDTO;

import java.util.List;
import java.util.UUID;

public interface AssignmentService {
    AssignmentResponseDTO createAssignment(AssignmentRequestDTO dto);
    List<AssignmentResponseDTO> getAssignmentsByCourse(UUID courseId);
    void deleteAssignment(UUID id);
}
