package org.education.onlneeducation.repository;

import org.education.onlneeducation.models.entity.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, UUID> {
    List<Lecture> findByCourseId(UUID courseId);
}
