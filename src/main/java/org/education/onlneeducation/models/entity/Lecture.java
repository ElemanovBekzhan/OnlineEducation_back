package org.education.onlneeducation.models.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "lectures")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String title;
    String pdfUrl;
    LocalDateTime uploadedAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    Course course;

}
