package com.shajar.university.repository;

import com.shajar.university.common.data.model.GraduateProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface GraduateProjectRepo extends JpaRepository<GraduateProject, Long> {
   Iterable<GraduateProject> findByYear(@Param("year") String year);
}
