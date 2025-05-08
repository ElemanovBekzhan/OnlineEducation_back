package org.education.onlneeducation.models.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "assignments")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Assignment {



    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String title;
    String description;
    LocalDate dueDate;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    Course course;


    @OneToMany(mappedBy = "assignment", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Submission> submissions = new ArrayList<>();

}
