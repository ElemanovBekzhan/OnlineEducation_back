package org.education.onlneeducation.repository;

import org.education.onlneeducation.models.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> {
}
