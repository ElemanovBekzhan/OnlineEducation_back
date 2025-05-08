package org.education.onlneeducation.models.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "submissions")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String fileUrl;
    LocalDateTime submittedAt = LocalDateTime.now();
    Integer grade;
    String feedback;

    @ManyToOne
    @JoinColumn(name = "assignment_id", nullable = false)
    Assignment assignment;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    User student;
}
