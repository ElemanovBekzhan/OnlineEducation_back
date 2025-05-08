package org.education.onlneeducation.service;


import org.education.onlneeducation.models.dto.LectureRequestDTO;
import org.education.onlneeducation.models.dto.LectureResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


public interface LectureService {
    LectureResponseDTO createLecture(LectureRequestDTO dto);
    List<LectureResponseDTO> getLecturesByCourse(UUID courseId);
    void deleteLecture(UUID id);
}
