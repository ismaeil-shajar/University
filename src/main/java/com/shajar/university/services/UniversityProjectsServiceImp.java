package com.shajar.university.services;

import com.shajar.university.common.data.model.UniversityProject;
import com.shajar.university.repository.UniversityProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class UniversityProjectsServiceImp implements ProjectsService<UniversityProject>{
    private final UniversityProjectRepo universityProjectRepo;

    @Autowired
    public UniversityProjectsServiceImp(UniversityProjectRepo universityProjectRepo) {
        this.universityProjectRepo = universityProjectRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public Set findAll() {
      Set<UniversityProject> universityProjects= new HashSet<>();
      universityProjectRepo.findAll().forEach(universityProjects::add);
      return universityProjects;
    }

    @Override
    public long count() {
        return universityProjectRepo.count();
    }

    @Override
    public Optional<UniversityProject> findById(Long id) {
        return universityProjectRepo.findById(id);
    }

    @Override
    public UniversityProject save(UniversityProject universityProject) {
        return universityProjectRepo.save(universityProject);
    }

    @Override
    public void delete(UniversityProject universityProject) {
        universityProject.setIsDeleted((short)1);
        universityProjectRepo.save(universityProject);
    }
}
