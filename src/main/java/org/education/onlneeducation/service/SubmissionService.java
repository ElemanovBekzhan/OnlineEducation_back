package org.education.onlneeducation.service;

import org.education.onlneeducation.models.dto.SubmissionRequestDTO;
import org.education.onlneeducation.models.dto.SubmissionResponseDTO;

import java.util.List;
import java.util.UUID;

public interface SubmissionService {
    SubmissionResponseDTO submitAssignment(SubmissionRequestDTO dto);
    List<SubmissionResponseDTO> getSubmissionsByAssignment(UUID assignmentId);
    SubmissionResponseDTO gradeSubmission(UUID submissionId, Integer grade, String feedback);
}
