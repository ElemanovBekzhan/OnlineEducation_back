package org.education.onlneeducation.controller;


import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.AssignmentRequestDTO;
import org.education.onlneeducation.models.dto.AssignmentResponseDTO;
import org.education.onlneeducation.service.AssignmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {
    private final AssignmentService assignmentService;


    @PostMapping
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    public ResponseEntity<AssignmentResponseDTO> create(@RequestBody AssignmentRequestDTO dto) {
        return ResponseEntity.ok(assignmentService.createAssignment(dto));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<AssignmentResponseDTO>> getByCourse(@PathVariable UUID courseId) {
        return ResponseEntity.ok(assignmentService.getAssignmentsByCourse(courseId));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        assignmentService.deleteAssignment(id);
        return ResponseEntity.noContent().build();
    }
}
