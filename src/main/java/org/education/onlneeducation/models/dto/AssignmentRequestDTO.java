package org.education.onlneeducation.models.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class AssignmentRequestDTO {
    UUID courseId;
    String title;
    String description;
    LocalDate dueDate;
}
