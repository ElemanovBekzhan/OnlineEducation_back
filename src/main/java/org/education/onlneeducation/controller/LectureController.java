package org.education.onlneeducation.controller;


import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.LectureRequestDTO;
import org.education.onlneeducation.models.dto.LectureResponseDTO;
import org.education.onlneeducation.service.LectureService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/lectures")
@RequiredArgsConstructor
public class LectureController {
    private final LectureService lectureService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    public ResponseEntity<LectureResponseDTO> createLecture(@RequestBody LectureRequestDTO dto) {
        return ResponseEntity.ok(lectureService.createLecture(dto));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<LectureResponseDTO>> getByCourse(@PathVariable UUID courseId) {
        return ResponseEntity.ok(lectureService.getLecturesByCourse(courseId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    public ResponseEntity<Void> deleteLecture(@PathVariable UUID id) {
        lectureService.deleteLecture(id);
        return ResponseEntity.noContent().build();
    }
}
