package org.education.onlneeducation.models.mapper;


import org.education.onlneeducation.models.dto.CourseRequestDTO;
import org.education.onlneeducation.models.dto.CourseResponseDTO;
import org.education.onlneeducation.models.entity.Course;
import org.education.onlneeducation.models.entity.User;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public Course toEntity(CourseRequestDTO dto, User teacher) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setTeacher(teacher);
        return course;
    }

    public CourseResponseDTO toDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();
        dto.setId(course.getId());
        dto.setTitle(course.getTitle());
        dto.setDescription(course.getDescription());
        dto.setTeacherId(course.getTeacher().getId());
        dto.setTeacherName(course.getTeacher().getUsername());
        dto.setCreatedAt(course.getCteatedAt());
        return dto;
    }
}
