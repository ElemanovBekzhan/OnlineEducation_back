package org.education.onlneeducation.service.Impl;

import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.SubmissionRequestDTO;
import org.education.onlneeducation.models.dto.SubmissionResponseDTO;
import org.education.onlneeducation.models.entity.Assignment;
import org.education.onlneeducation.models.entity.Submission;
import org.education.onlneeducation.models.entity.User;
import org.education.onlneeducation.models.mapper.SubmissionMapper;
import org.education.onlneeducation.repository.AssignmentRepository;
import org.education.onlneeducation.repository.SubmissionRepository;
import org.education.onlneeducation.repository.UserRepository;
import org.education.onlneeducation.service.SubmissionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class SubmissionServiceImpl implements SubmissionService {
    private final SubmissionRepository submissionRepository;
    private final AssignmentRepository assignmentRepository;
    private final UserRepository userRepository;
    private final SubmissionMapper submissionMapper;

    @Override
    public SubmissionResponseDTO submitAssignment(SubmissionRequestDTO dto) {
        Assignment assignment = assignmentRepository.findById(dto.getAssignmentId())
                .orElseThrow(() -> new RuntimeException("Assignment not found"));
        User student = userRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Submission s = submissionMapper.toEntity(dto, assignment, student);
        return submissionMapper.toDTO(submissionRepository.save(s));
    }

    @Override
    public List<SubmissionResponseDTO> getSubmissionsByAssignment(UUID assignmentId) {
        return submissionRepository.findByAssignmentId(assignmentId).stream()
                .map(submissionMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SubmissionResponseDTO gradeSubmission(UUID submissionId, Integer grade, String feedback) {
        Submission s = submissionRepository.findById(submissionId)
                .orElseThrow(() -> new RuntimeException("Submission not found"));
        s.setGrade(grade);
        s.setFeedback(feedback);
        return submissionMapper.toDTO(submissionRepository.save(s));
    }
}
