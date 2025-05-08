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
public class CourseResponseDTO {
    UUID id;
    String title;
    String description;
    UUID teacherId;
    String teacherName;
    LocalDateTime createdAt;
}
