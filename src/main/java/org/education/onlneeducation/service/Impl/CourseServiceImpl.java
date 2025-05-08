package org.education.onlneeducation.service.Impl;

import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.CourseRequestDTO;
import org.education.onlneeducation.models.dto.CourseResponseDTO;
import org.education.onlneeducation.models.entity.Course;
import org.education.onlneeducation.models.entity.User;
import org.education.onlneeducation.models.mapper.CourseMapper;
import org.education.onlneeducation.repository.CourseRepository;
import org.education.onlneeducation.repository.UserRepository;
import org.education.onlneeducation.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseResponseDTO createCourse(CourseRequestDTO dto) {
        User teacher = userRepository.findById(dto.getTeacherId())
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        Course course = courseMapper.toEntity(dto, teacher);
        Course saved = courseRepository.save(course);
        return courseMapper.toDTO(saved);
    }

    @Override
    public List<CourseResponseDTO> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(courseMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CourseResponseDTO getCourseById(UUID id) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        return courseMapper.toDTO(course);
    }

    @Override
    public CourseResponseDTO updateCourse(UUID id, CourseRequestDTO dto) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        Course updated = courseRepository.save(course);
        return courseMapper.toDTO(updated);
    }

    @Override
    public void deleteCourse(UUID id) {
        courseRepository.deleteById(id);
    }
}
