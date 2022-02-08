package com.shajar.university.services;

import com.shajar.university.common.data.model.GraduateProject;
import com.shajar.university.repository.GraduateProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@Transactional
public class GraduateProjectsServiceImp implements ProjectsService<GraduateProject>{
    private final GraduateProjectRepo graduateProjectRepo;

    @Autowired
    public GraduateProjectsServiceImp(GraduateProjectRepo graduateProjectRepo) {
        this.graduateProjectRepo = graduateProjectRepo;
    }

    @Override
    @Transactional(readOnly = true)
    public Set findAll() {
      Set<GraduateProject> graduateProjects= new HashSet<>();
      graduateProjectRepo.findAll().forEach(graduateProjects::add);
      return graduateProjects;
    }

    @Transactional(readOnly = true)
    public Set findAll(String year) {
      Set<GraduateProject> graduateProjects= new HashSet<>();
      graduateProjectRepo.findByYear(year).forEach(graduateProjects::add);
      return graduateProjects;
    }

    @Override
    public long count() {
        return graduateProjectRepo.count();
    }

    @Override
    public Optional<GraduateProject> findById(Long id) {
        return graduateProjectRepo.findById(id);
    }

    @Override
    public GraduateProject save(GraduateProject graduateProject) {
        return graduateProjectRepo.save(graduateProject);
    }

    @Override
    public void delete(GraduateProject graduateProject) {
        graduateProject.setIsDeleted((short)1);
        graduateProjectRepo.save(graduateProject);
    }
}
