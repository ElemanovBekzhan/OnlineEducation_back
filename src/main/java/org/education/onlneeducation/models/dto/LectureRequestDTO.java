package org.education.onlneeducation.models.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class LectureRequestDTO {
    UUID courseId;
    String title;
    String pdfUrl;
}
