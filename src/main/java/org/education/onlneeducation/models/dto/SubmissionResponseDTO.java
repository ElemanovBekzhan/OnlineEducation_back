package org.education.onlneeducation.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SubmissionResponseDTO {
    UUID id;
    UUID assignmentId;
    UUID studentId;
    String studentName;
    String fileUrl;
    LocalDateTime submittedAt;
    Integer grade;
    String feedback;
}
