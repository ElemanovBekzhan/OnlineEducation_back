package org.education.onlneeducation.service.Impl;

import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.AssignmentRequestDTO;
import org.education.onlneeducation.models.dto.AssignmentResponseDTO;
import org.education.onlneeducation.models.entity.Course;
import org.education.onlneeducation.models.mapper.AssignmentMapper;
import org.education.onlneeducation.repository.AssignmentRepository;
import org.education.onlneeducation.repository.CourseRepository;
import org.education.onlneeducation.service.AssignmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class AssignmentServiceImpl implements AssignmentService {
    private final AssignmentRepository assignmentRepository;
    private final CourseRepository courseRepository;
    private final AssignmentMapper assignmentMapper;

    @Override
    public AssignmentResponseDTO createAssignment(AssignmentRequestDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return assignmentMapper.toDTO(
                assignmentRepository.save(assignmentMapper.toEntity(dto, course)));
    }

    @Override
    public List<AssignmentResponseDTO> getAssignmentsByCourse(UUID courseId) {
        return assignmentRepository.findByCourseId(courseId).stream()
                .map(assignmentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAssignment(UUID id) {
        assignmentRepository.deleteById(id);
    }
}
