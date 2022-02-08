package com.shajar.university.repository;

import com.shajar.university.common.data.model.UniversityProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityProjectRepo extends JpaRepository<UniversityProject, Long> {
}
