package org.education.onlneeducation.models.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class LectureResponseDTO {
    UUID id;
    UUID courseId;
    String title;
    String pdfUrl;
    LocalDateTime uploadedAt;
    String courseTitle;
}
