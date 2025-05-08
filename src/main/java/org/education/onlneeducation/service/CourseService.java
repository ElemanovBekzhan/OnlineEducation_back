package org.education.onlneeducation.service;

import org.education.onlneeducation.models.dto.CourseRequestDTO;
import org.education.onlneeducation.models.dto.CourseResponseDTO;

import java.util.List;
import java.util.UUID;

public interface CourseService {

    CourseResponseDTO createCourse(CourseRequestDTO dto);
    List<CourseResponseDTO> getAllCourses();
    CourseResponseDTO getCourseById(UUID id);
    CourseResponseDTO updateCourse(UUID id, CourseRequestDTO dto);
    void deleteCourse(UUID id);
}
