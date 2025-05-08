package org.education.onlneeducation.service.Impl;

import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.LectureRequestDTO;
import org.education.onlneeducation.models.dto.LectureResponseDTO;
import org.education.onlneeducation.models.entity.Course;
import org.education.onlneeducation.models.entity.Lecture;
import org.education.onlneeducation.models.mapper.LectureMapper;
import org.education.onlneeducation.repository.CourseRepository;
import org.education.onlneeducation.repository.LectureRepository;
import org.education.onlneeducation.service.LectureService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LectureServiceImpl implements LectureService {
    private final LectureRepository lectureRepository;
    private final CourseRepository courseRepository;
    private final LectureMapper lectureMapper;


    @Override
    public LectureResponseDTO createLecture(LectureRequestDTO dto) {
        Course course = courseRepository.findById(dto.getCourseId())
                .orElseThrow(() -> new RuntimeException("Course not found"));
        Lecture lecture = lectureMapper.toEntity(dto, course);
        Lecture saved = lectureRepository.save(lecture);
        return lectureMapper.toDTO(saved);
    }

    @Override
    public List<LectureResponseDTO> getLecturesByCourse(UUID courseId) {
        return lectureRepository.findByCourseId(courseId).stream()
                .map(lectureMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteLecture(UUID id) {
        lectureRepository.deleteById(id);
    }
}
