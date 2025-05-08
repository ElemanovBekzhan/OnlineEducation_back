package org.education.onlneeducation.models.mapper;

import org.education.onlneeducation.models.dto.SubmissionRequestDTO;
import org.education.onlneeducation.models.dto.SubmissionResponseDTO;
import org.education.onlneeducation.models.entity.Assignment;
import org.education.onlneeducation.models.entity.Submission;
import org.education.onlneeducation.models.entity.User;
import org.springframework.stereotype.Component;

@Component
public class SubmissionMapper {
    public Submission toEntity(SubmissionRequestDTO dto, Assignment assignment, User student) {
        Submission s = new Submission();
        s.setAssignment(assignment);
        s.setStudent(student);
        s.setFileUrl(dto.getFileUrl());
        return s;
    }

    public SubmissionResponseDTO toDTO(Submission s) {
        SubmissionResponseDTO dto = new SubmissionResponseDTO();
        dto.setId(s.getId());
        dto.setAssignmentId(s.getAssignment().getId());
        dto.setStudentId(s.getStudent().getId());
        dto.setStudentName(s.getStudent().getUsername());
        dto.setFileUrl(s.getFileUrl());
        dto.setSubmittedAt(s.getSubmittedAt());
        dto.setGrade(s.getGrade());
        dto.setFeedback(s.getFeedback());
        return dto;
    }
}
