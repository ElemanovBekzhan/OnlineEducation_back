package org.education.onlneeducation.models.mapper;


import org.education.onlneeducation.models.dto.AssignmentRequestDTO;
import org.education.onlneeducation.models.dto.AssignmentResponseDTO;
import org.education.onlneeducation.models.entity.Assignment;
import org.education.onlneeducation.models.entity.Course;
import org.springframework.stereotype.Component;

@Component
public class AssignmentMapper {
    public Assignment toEntity(AssignmentRequestDTO dto, Course course) {
        Assignment a = new Assignment();
        a.setTitle(dto.getTitle());
        a.setDescription(dto.getDescription());
        a.setDueDate(dto.getDueDate());
        a.setCourse(course);
        return a;
    }

    public AssignmentResponseDTO toDTO(Assignment assignment) {
        AssignmentResponseDTO dto = new AssignmentResponseDTO();
        dto.setId(assignment.getId());
        dto.setCourseId(assignment.getCourse().getId());
        dto.setCourseTitle(assignment.getCourse().getTitle());
        dto.setTitle(assignment.getTitle());
        dto.setDescription(assignment.getDescription());
        dto.setDueDate(assignment.getDueDate());
        return dto;
    }
}
