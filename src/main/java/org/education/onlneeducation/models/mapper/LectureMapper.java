package org.education.onlneeducation.models.mapper;


import org.education.onlneeducation.models.dto.LectureRequestDTO;
import org.education.onlneeducation.models.dto.LectureResponseDTO;
import org.education.onlneeducation.models.entity.Course;
import org.education.onlneeducation.models.entity.Lecture;
import org.springframework.stereotype.Component;

@Component
public class LectureMapper {
    public Lecture toEntity(LectureRequestDTO dto, Course course) {
        Lecture lecture = new Lecture();
        lecture.setTitle(dto.getTitle());
        lecture.setPdfUrl(dto.getPdfUrl());
        lecture.setCourse(course);
        return lecture;
    }

    public LectureResponseDTO toDTO(Lecture lecture) {
        LectureResponseDTO dto = new LectureResponseDTO();
        dto.setId(lecture.getId());
        dto.setCourseId(lecture.getCourse().getId());
        dto.setCourseTitle(lecture.getCourse().getTitle());
        dto.setTitle(lecture.getTitle());
        dto.setPdfUrl(lecture.getPdfUrl());
        dto.setUploadedAt(lecture.getUploadedAt());
        return dto;
    }
}
