package com.shajar.university.services;

import com.shajar.university.common.data.model.BaseProject;

import java.util.Optional;
import java.util.Set;

public interface ProjectsService<T extends BaseProject> {

    Set findAll();

    long count();

    Optional<T> findById(Long id);

    T save(T project);

    void delete(T project);
}
