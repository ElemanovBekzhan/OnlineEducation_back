package org.education.onlneeducation.models.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "enrollments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    User student;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    Course course;

    LocalDateTime enrollmentDate = LocalDateTime.now();

}
