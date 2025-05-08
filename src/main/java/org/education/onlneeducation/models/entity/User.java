package org.education.onlneeducation.models.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.education.onlneeducation.models.enums.Role;

import java.util.*;

@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    @Column(unique = true, nullable = false)
    String username;

    @Column(nullable = false)
    String password;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    Set<Role> roles = new HashSet<>();

    //Связи
    @OneToMany(mappedBy = "teacher")
    List<Course> courses = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    List<Enrollment> enrollments = new ArrayList<>();

    @OneToMany(mappedBy = "student")
    List<Submission> submissions = new ArrayList<>();



}
