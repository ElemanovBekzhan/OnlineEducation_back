package org.education.onlneeducation.controller;


import lombok.RequiredArgsConstructor;
import org.education.onlneeducation.models.dto.SubmissionRequestDTO;
import org.education.onlneeducation.models.dto.SubmissionResponseDTO;
import org.education.onlneeducation.service.SubmissionService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/submissions")
public class SubmissionController {
    private final SubmissionService submissionService;

    @PostMapping
    @PreAuthorize("hasAuthority('STUDENT')")
    public ResponseEntity<SubmissionResponseDTO> submit(@RequestBody SubmissionRequestDTO dto) {
        return ResponseEntity.ok(submissionService.submitAssignment(dto));
    }

    @GetMapping("/assignment/{assignmentId}")
    public ResponseEntity<List<SubmissionResponseDTO>> forAssignment(@PathVariable UUID assignmentId) {
        return ResponseEntity.ok(submissionService.getSubmissionsByAssignment(assignmentId));
    }

    @PutMapping("/{id}/grade")
    @PreAuthorize("hasAnyAuthority('TEACHER','ADMIN')")
    public ResponseEntity<SubmissionResponseDTO> grade(
            @PathVariable UUID id,
            @RequestParam Integer grade,
            @RequestParam String feedback) {
        return ResponseEntity.ok(submissionService.gradeSubmission(id, grade, feedback));
    }
}
